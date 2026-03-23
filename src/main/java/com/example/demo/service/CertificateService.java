package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Service
public class CertificateService {

    public byte[] generateCertificate(String name, String quiz, int score) {

        String date = LocalDate.now().toString();

        String html = "<html>"
                + "<head>"
                + "<style>"

                + "@page { size: A4; margin: 30px; }"

                + "body {"
                + "font-family: 'Times New Roman';"
                + "}"

                + ".outer {"
                + "width: 100%;"
                + "height: 100%;"
                + "border: 10px solid #2c3e50;"
                + "padding: 30px;"
                + "box-sizing: border-box;"
                + "}"

                + "table {"
                + "width: 100%;"
                + "height: 100%;"
                + "text-align: center;"
                + "}"

                + "h1 { font-size: 28px; margin-bottom: 20px; }"
                + "h2 { font-size: 24px; margin: 10px; }"
                + "h3 { font-size: 20px; }"
                + "p { font-size: 16px; }"

                + "</style>"
                + "</head>"

                + "<body>"
                + "<div class='outer'>"
                + "<table>"
                + "<tr><td>"

                + "<h1>CERTIFICATE OF COMPLETION</h1>"

                + "<p>This is to certify that</p>"

                + "<h2>" + name + "</h2>"

                + "<p>has successfully completed the quiz</p>"

                + "<h3>" + quiz + "</h3>"

                + "<p>Score : " + score + "</p>"

                + "<p>Date : " + date + "</p>"

                + "</td></tr>"
                + "</table>"
                + "</div>"
                + "</body>"
                + "</html>";

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(out);
            builder.run();

            return out.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}