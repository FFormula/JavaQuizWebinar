package service;

import java.io.*;

public class DialogStream implements IDialog {

    private BufferedReader reader;
    private BufferedWriter writer;

    public DialogStream(InputStream in, OutputStream out) {
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new BufferedWriter(new OutputStreamWriter(out));
    }

    @Override
    public void print(String message) {
        try {
            writer.write("*" + message);
            writer.flush();
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }

    @Override
    public String input() {
        try {
            return reader.readLine();
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }
}
