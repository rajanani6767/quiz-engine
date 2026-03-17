package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class CertificateService {

    public String generateCertificate(String name, String quiz, int score) {

        String date = LocalDate.now().toString();

        String html = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<style>"

                + "body{"
                + "margin:0;"
                + "background:#f4f4f4;"
                + "font-family:'Times New Roman';"
                + "}"

                + ".container{"
                + "display:flex;"
                + "justify-content:center;"
                + "align-items:center;"
                + "height:100vh;"
                + "}"

                + ".certificate{"
                + "width:900px;"
                + "padding:50px;"
                + "border:12px solid #2c3e50;"
                + "background:white;"
                + "text-align:center;"
                + "box-shadow:0 0 20px rgba(0,0,0,0.2);"
                + "}"

                + "h1{"
                + "font-size:42px;"
                + "margin-bottom:20px;"
                + "}"

                + ".name{"
                + "font-size:32px;"
                + "font-weight:bold;"
                + "margin:20px;"
                + "}"

                + ".quiz{"
                + "font-size:24px;"
                + "margin-top:15px;"
                + "}"

                + ".score{"
                + "font-size:20px;"
                + "margin-top:10px;"
                + "}"

                + ".date{"
                + "margin-top:30px;"
                + "font-size:16px;"
                + "}"

                + "</style>"
                + "</head>"

                + "<body>"
                + "<div class='container'>"
                + "<div class='certificate'>"

                + "<h1>CERTIFICATE OF COMPLETION</h1>"

                + "<p>This is to certify that</p>"

                + "<div class='name'>" + name + "</div>"

                + "<p>has successfully completed the quiz</p>"

                + "<div class='quiz'>" + quiz + "</div>"

                + "<div class='score'>Score : " + score + "</div>"

                + "<div class='date'>Date: " + date + "</div>"

                + "</div>"
                + "</div>"

                + "</body>"
                + "</html>";

        return html;
    }
}