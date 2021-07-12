package Zad1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;

public class Futil extends SimpleFileVisitor<Path> {

    public static void processDir(String name,String fIleName) {
        FileChannel fileChannel;
        Charset charsetDecode = Charset.forName("Cp1250");
        Charset charsetEncode = Charset.forName("UTF-8");
        try {
            fileChannel = FileChannel.open(Paths.get(fIleName),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
            Files.walk(Paths.get(name)).filter(Files::isRegularFile).forEach((Path path)->{
                try {
                    FileChannel fileChannelRead = FileChannel.open(path,StandardOpenOption.READ);
                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)fileChannelRead.size());
                    fileChannelRead.read(byteBuffer);
                    byteBuffer.flip();
                    CharBuffer charBuffer = charsetDecode.decode(byteBuffer);
                    fileChannel.write(charsetEncode.encode(charBuffer));
                    System.out.println(path);
                    fileChannelRead.close();
                }catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            fileChannel.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
