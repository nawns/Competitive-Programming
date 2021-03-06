import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static int MAX_NODE = 0;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int d = sc.nextInt();
      int l = sc.nextInt();
      MAX_NODE = (int)Math.pow(2, d);
      out.println(bs(1, l, d));
    }
    out.close();
  }

  public static int bs(int d, int balls, int max) {
    int left = d * 2;
    int right = left + 1;
    if (left < MAX_NODE && right < MAX_NODE) {
      if (balls % 2 == 0) {
        return bs(right, balls/2, max);
      } else {
        return bs(left, balls/2 + 1, max);
      }
    } else {
      return d;
    }
  }


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    public boolean hasNext() {
      try {
        boolean a = br.ready();
        return a;
      } catch (IOException e) {
        return false;
      }
    }

    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
 
    public int nextInt() {
      return Integer.parseInt(next());
    }
 
    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public char nextChar() {
      return next().charAt(0);
    }

    public String nextLine() {
      String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
    }
  }
}
