package service;

import com.rabbitmq.client.*;
import org.json.JSONException;
import org.json.JSONObject;
import client.BankContact;
import ws.InterestRateResponse;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RiskAverseReceiver {

    //uses the Routing strategy

    private static final String EXCHANGE_NAME = "recipientList_translator";
    private static final String bank = "RiskAverseBank";

    public static void main(String[] argv) throws Exception {

        //receives message like: {"ssn":"123456-6543","creditScore":774,"loanAmount":1234567.0,"loanDuration":"6"}
        // which is binded with the name of the bank

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();

        //create a binding for CphBusinessXMLTranslator
        channel.queueBind(queueName, EXCHANGE_NAME, bank);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");

                System.out.println(" [x] Received on key binding'" + envelope.getRoutingKey() + "':'" + message + "'");

                try {
                    JSONObject j = new JSONObject(message);
                    String ssn = j.getString("ssn");
                    Double loanAmount = j.getDouble("loanAmount");
                    int creditScore = j.getInt("creditScore");
                    //convert years in months
                    String loanDuration = j.getString("loanDuration");
                    System.out.println("Before soap req.");
                    //take resp and send it to normalizer
                    BankContact bc = new BankContact();

                    InterestRateResponse irr = bc.getResponse(ssn,creditScore,loanAmount,loanDuration);
                    System.out.println("Interest Rate response from SOAP: " + irr.getSsn() + " " + irr.getInterestRate());

                    //send it to normalizer as a JSON object and add the name of the bank
                    JSONObject jo = new JSONObject();
                    jo.put("ssn", irr.getSsn());
                    jo.put("interestRate", irr.getInterestRate());
                    jo.put("bank", bank);

                    NormalizerSender nz = new NormalizerSender();
                    nz.sendToNormalizer(jo.toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }


            }
        };
        channel.basicConsume(queueName, true, consumer);
    }

}
