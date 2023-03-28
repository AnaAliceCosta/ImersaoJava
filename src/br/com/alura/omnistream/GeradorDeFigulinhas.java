package br.com.alura.omnistream;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigulinhas {
    public static void cria(InputStream inputStream, String nomeArquivo) throws IOException{
      
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura,BufferedImage.TRANSLUCENT);

        Graphics2D graphics =(Graphics2D) novaImagem.getGraphics();
        
        graphics.drawImage(imagemOriginal,0, 0, null);
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD,  100 );
        
        graphics.setFont(fonte);
        graphics.setColor(Color.yellow);

        graphics.drawString("TOPZERA", 0 , novaAltura -100);


        ImageIO.write(novaImagem, "png", new File(nomeArquivo));


    }
}
