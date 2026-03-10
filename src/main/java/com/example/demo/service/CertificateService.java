package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    public String generateCertificate(String name, String quiz, int score) {

        String html = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<style>"
                + "body{"
                + "background:#f4f4f4;"
                + "display:flex;"
                + "justify-content:center;"
                + "align-items:center;"
                + "height:100vh;"
                + "font-family:'Times New Roman';"
                + "}"
                + ".certificate{"
                + "width:800px;"
                + "padding:40px;"
                + "border:10px solid #2c3e50;"
                + "background:white;"
                + "text-align:center;"
                + "}"
                + "h1{font-size:40px;margin-bottom:30px;}"
                + ".name{font-size:30px;font-weight:bold;margin:20px;}"
                + ".quiz{font-size:24px;margin-top:20px;}"
                + ".score{font-size:20px;margin-top:15px;}"
                + "</style>"
                + "</head>"

                + "<body>"
                + "<div class='certificate'>"

                + "<h1>CERTIFICATE OF COMPLETION</h1>"

                + "<p>This is to certify that</p>"

                + "<div class='name'>" + name + "</div>"

                + "<p>has successfully completed the quiz</p>"

                + "<div class='quiz'>" + quiz + "</div>"

                + "<div class='score'>Score : " + score + "</div>"

                + "</div>"
                + "</body>"
                + "</html>";

        return html;
    }
}