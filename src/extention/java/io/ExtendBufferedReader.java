package extention.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class ExtendBufferedReader extends BufferedReader {

    public ExtendBufferedReader(Reader in) {
        super(in);
    }

	public ExtendBufferedReader(Reader in, int sz) {
        super(in, sz);
    }

	@Override
    public String readLine() throws IOException {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        try {
            while ((num = this.read()) >= 0) {
                sb.append((char) num);
                switch ((char) num) {
                case '\r':
                case '\n':
                    return sb.toString();
                default:
                    break;
                }
            }
        } catch (IOException e) {
            throw e;
        }
 
        if (sb.length() == 0) {
            return null;
        } else {
            return sb.toString();
        }
    }
}
