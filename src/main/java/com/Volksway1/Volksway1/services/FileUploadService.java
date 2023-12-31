package com.Volksway1.Volksway1.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedOutputStream;
import java.io.File;

@Service
public class FileUploadService {

    private final Path diretorioImg = Paths.get(System.getProperty("User.dir")+"\\src\\main\\resources\\static\\img");


    public String fazerUpload(MultipartFile imagem) throws IOException {
        if (imagem.isEmpty()){
            System.out.println("imagem vazia");
            return null;

        }
        String[] nomeArquivoArray = imagem.getOriginalFilename().split("\\.");
        String novoNome = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmss"));
        String extencaoArquivo = nomeArquivoArray[nomeArquivoArray.length -1];

        String nomeImg = novoNome + "." + extencaoArquivo;

        File imagemCriada = new File(diretorioImg + "\\" + nomeImg);

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(imagemCriada));

        stream.write(imagem.getBytes());
        stream.close();


        return nomeImg;

    }
}
