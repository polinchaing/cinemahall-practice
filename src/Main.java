public class Main {
    public static void main(String[] args) {
        Main main= new Main();//create new object
        System.out.println(main.fac(5));//call obj and call public method fac to use
        System.out.println(main.hello(1,2,3,4,5));//call obj and call public method hi to use
    }
    public int hello(int...hi){
        int sum=0;
        for(int h : hi){
            sum +=h;
        }
        return sum;
    }
    public int fac(int a){
        if(a==1)return 1;
        else return a*fac(a-1);
    }
}
