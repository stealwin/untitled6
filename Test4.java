package org.apache.http.examples.client;

/**
 * Created by viachslav on 14.10.2018.
 */

        import java.awt.*;
        import java.awt.event.*;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import javax.swing.*;
        import javax.swing.text.Element;
        import javax.swing.text.html.ListView;

public class Test4  {


    JTextField label1;
    JTextField label2;
    JSONObject sh2;
    JSONObject sh3;





    Test4() {
//создаем панель
        JPanel windowContent = new JPanel();
        //Задаем менеджер отображения для этой панели
        GridLayout g1 = new GridLayout(2, 1);
        windowContent.setLayout(g1);

        label1 = new JTextField();


        label2 = new JTextField();


        windowContent.add(label1);
        windowContent.add(label2);
        //Создаем фрейм и задаем для него панель
        JFrame frame = new JFrame("Статьи");
        frame.setContentPane(windowContent);
        frame.pack();
        frame.setVisible(true);




    }

    public void call_me() throws Exception {
        String url = "http://jsonplaceholder.typicode.com/posts";

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();


        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }
        in.close();


        //Read JSON response and print
        JSONArray myResponse = new JSONArray(response.toString());
//        for (int i=0;i<myResponse.length();i++){
//            JSONObject sh = new JSONObject(myResponse.get(i).toString());
//
//
//
//
//
//        }
         sh2 = myResponse.getJSONObject(3);
        label2.setText(sh2.getString("title"));

         sh3 = myResponse.getJSONObject(1);
        label1.setText((String) sh3.get("title"));
        label1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {
                label1.setText("");
                label1.setText(sh3.getString("body"));
                label2.setVisible(false);


            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
        label2.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

                label2.setText("");
                label2.setText(sh2.getString("body"));
                label1.setVisible(false);

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });













    }




    public static void main(String[] args) throws Exception {
        Test4 n = new Test4();
        n.call_me();




/*
        try {
            Test4.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


}

