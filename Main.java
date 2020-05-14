import java.util.Random;

class MyThread extends Thread {
    private int seed;
    private String name;
    // private int count;
    
    public MyThread(int seed, String name) {
      this.seed = seed;
      this.name = name;
    }
    
    @Override
    public void run() {
      for(int i = 0; i < 15; i++) {
        System.out.println(name + " " + seed++);
      }
    }
}

class Main {
  public static void main(String[] args) {
    Random rnd = new Random();
    
    int rand_seed1;
    int rand_seed2;
    
    do {
    rand_seed1 = rnd.nextInt(50);
    rand_seed2 = rnd.nextInt(50);
    } while (rand_seed1 == rand_seed2);
    
    MyThread thread1 = new MyThread(rand_seed1, "T#1");
    MyThread thread2 = new MyThread(rand_seed2, "T#2");
    
    thread1.start();
    thread2.start();
  }
}