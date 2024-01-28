                                            //Laptop Buying 
import java.util.*;
public class laptop_buying{
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        basic_login obj = new basic_login();
        obj.welcome();
        obj.welcome_login();
        newLap laptop[] = new newLap[30];
        newLap compare[] = new newLap[3];
        for(int i=0; i<3; i++){
            compare[i] = new newLap();
        }
        newLap lap = new newLap();
        for(int i=0; i<30; i++){
            laptop[i] = new newLap();
        }
        for(int i=0; i<30; i++){
            laptop[i].setData(laptop);
        }
        newLap final1 = new newLap();
        boolean flag = true;
        while(flag){
            System.out.println("Enter choice for the following!!!");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.println("1.Search By Brand!");
            System.out.println("2.Search in Budget!");
            System.out.println("3.On the basis of purpose!");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            int choice = s.nextInt();
            switch(choice){
                case 1:
                lap.search_brand(laptop);
                flag = false;
                break;
                case 2:
                compare = lap.by_budget(laptop);
                for(int i=0; i<3; i++){
                    compare[i].display();
                }
                final1 = lap.finalize(compare);
                lap.bill(final1);
                flag = false;
                break;
                case 3:
                System.out.println("Select type of Laptop!!!!!");
                boolean flag1 = true;
                newLap finaa = new newLap();
                while(flag1){
                    System.out.println("1.For Gaming Laptop!!!!!");
                    System.out.println("2.For Non-Gaming Laptop!!!!!");
                    int choice1 = s.nextInt();
                    switch(choice1){
                        case 1:
                        compare = lap.Gaming(laptop);
                        for(int i=0; i<3; i++){
                            compare[i].display();
                        }
                        finaa = lap.finalize(compare);
                        lap.bill(finaa);
                        flag = false;
                        break;
                        case 2:
                        compare = lap.Non_Gaming(laptop);
                        for(int i=0; i<3; i++){
                            compare[i].display();
                        }
                        finaa = lap.finalize(compare);
                        lap.bill(finaa);
                        flag = false;
                        break;
                        default:
                        break;
                    }
                    break;
                }
                flag = false;
                break;
                /*case 4:

                break;*/
                default:
                System.out.println("Enter a valid choice!!!!");
                break;
            }
        }
    }
    
}
class basic_login{
    String name;
    String mob_no;
    int age;
    int pin;
    Scanner s = new Scanner(System.in);
    public void welcome(){
        System.out.println("                                           |------------|");
        System.out.println("                       --------------------|LAPTOP STORE|--------------------");
        System.out.println("                      |                    |------------|                    |");
        System.out.println("                      |                                                      |");
        System.out.println("                      |                                                      |");
        System.out.println();
    }
    public void welcome_login(){
        System.out.println("Welcome to the online portal of LAPTOP STORE!!!!!");
        System.out.println("Are you on this portal for the first time or have you visited this portal earlier???");
        System.out.println("Enter YES for first time NO for Login!!!!!");
        String first_ornot = s.nextLine();
        if(first_ornot.equalsIgnoreCase("yes")){
            register();
        }
        else{
            login();
        }
    }
    public void register(){
        System.out.print("Enter your name: ");
        name = s.nextLine();
        int flag;
        while(true){
            flag=0;
            System.out.print("Enter your mobile number: ");
            mob_no = s.nextLine();
            if(mob_no.length()==10){
                for(int i=0; i<10; i++){
                    if(mob_no.charAt(0)!='0'){
                        if(mob_no.charAt(i)=='0' || mob_no.charAt(i)=='1' || mob_no.charAt(i)=='2' || mob_no.charAt(i)=='3' || mob_no.charAt(i)=='4' || mob_no.charAt(i)=='5' || mob_no.charAt(i)=='6' || mob_no.charAt(i)=='7' || mob_no.charAt(i)=='8' || mob_no.charAt(i)=='9'){
                            //System.out.println(mob_no.charAt(i)); 
                            flag++;
                        }
                    }
                }
            }
        if(flag==10)
        {
            System.out.println("login done"); 
            break;
        }
        else{
            System.out.println("Enter a valid mobile phone number!!!!!");
        }
            
            if(mob_no.charAt(0)=='6'){
                System.out.println("As we can see your number starts with 6!!!!");
                System.out.println("This site being sponsored by our Share Holders you can get a special discount on all products of OURS!!!!!!");
                System.out.println("Congrats the minimum discount is of 10% and maximum of 35% in multiples of 5!!!!");
                int arr[] = {10,15,20,25,30,35};
                System.out.println("A discount of "+arr[new Random().nextInt(arr.length)]+"% is availed to you!!!!!!");
            }
        }
        System.out.println("A 6 digit OTP has been sent to the Number please enter below!!!");
        int flagg=0;
        while(flagg==0){
            int i = new Random().nextInt(900000) + 100000;//otp for number greater than 100000 for 6 digit OTP
            System.out.println("OTP for registeration is: "+i);
            System.out.print("Please enter the OTP: ");
            String OTP1 = Integer.toString(i);
            String OTP = s.nextLine();
            if(OTP.equals(OTP1)){
                System.out.println("Registeration Successful WELCOME to the family!!!!!!!");
                flagg=1;
            }
            else{
                System.out.println("OOPS entered OTP does not match the OTP sent!!!!Try again!");
                System.out.println("Please Re-Enter the new OTP sent!!!!");
            }
        }
        
        System.out.print("Enter your age: ");
        age = s.nextInt();
        if(age>=18){
        }
        else{
            System.out.println("Please ensure to be with one of a person above 18 years for better guidance!!!!!");
        }
        System.out.println("Welcome To OUR Online Store!!!!!!!!");
        pin = new Random().nextInt(9000) + 1000;
        System.out.println("Do remember this four Digit randomly generated PIN for future reference "+pin);
    }
    public void login(){
        System.out.print("Please enter your name: ");
        name = s.nextLine();
        int flag;
        while(true){
            flag=0;
            System.out.print("Enter your mobile number: ");
            mob_no = s.nextLine();
            if(mob_no.length()==10){
                for(int i=0; i<10; i++){
                    if(mob_no.charAt(0)!='0'){
                        if(mob_no.charAt(i)=='0' || mob_no.charAt(i)=='1' || mob_no.charAt(i)=='2' || mob_no.charAt(i)=='3' || mob_no.charAt(i)=='4' || mob_no.charAt(i)=='5' || mob_no.charAt(i)=='6' || mob_no.charAt(i)=='7' || mob_no.charAt(i)=='8' || mob_no.charAt(i)=='9'){
                            //System.out.println(mob_no.charAt(i)); 
                            flag++;
                        }
                    }
                }
            }
        if(flag==10)
        {
            System.out.println("login done"); 
            break;
        }
        else{
            System.out.println("Enter a valid mobile phone number!!!!!");
        }
        }
        
        //long temp1=mob_no;
        System.out.println("A 6 digit OTP has been sent to the Number please enter below!!!");
        int flagg=0;
        while(flagg==0){
            int i = new Random().nextInt(900000) + 100000;//otp for number greater than 100000 for 6 digit OTP
            System.out.println("OTP for login is: "+i);
            System.out.print("Please enter the OTP: ");
            String OTP1 = Integer.toString(i);
            String OTP = s.nextLine();
            if(OTP.equals(OTP1)){
                System.out.println("LOGIN SUCCESSFUL!!!!!");
                flagg=1;
                
            }
            else{
                System.out.println("OOPS entered OTP does not match the OTP sent!!!!Try again!");
                System.out.println("Please Re-Enter the new OTP sent!!!!");
            }
        }
    }
}
class newLap{
    Scanner s = new Scanner(System.in); 
    newLap fin;
    int choic1[] = new int[3];
    int choice1[] = new int[2];
    String graphic_card, windows_version, display_size, refresh_rate;
    int RAM, no_of_cores, product_no;
    long price;
    String processor, ram_type, lap_name, type, brand_name;
    newLap brand_choice[] = new newLap[6];
    public void setData(newLap lap[]){
        lap[0].brand_name = "ASUS";
        lap[0].graphic_card = "GeForce RTX 3050Ti";
        lap[0].RAM = 8;
        lap[0].price = 99000;
        lap[0].windows_version = "Windows 11";
        lap[0].refresh_rate = "144 Hz";
        lap[0].display_size = "15 inches";
        lap[0].no_of_cores = 8;
        lap[0].processor = "AMD Ryzen 7 4800H";
        lap[0].lap_name = "ROG Strix G15";
        lap[0].ram_type = "DDR6";
        lap[0].type = "Gaming";
        lap[0].product_no = 1;

        lap[1].brand_name = "ASUS";
        lap[1].graphic_card = "GeForce RTX 3050";
        lap[1].RAM = 8;
        lap[1].price = 85000;
        lap[1].windows_version = "Windows 11";
        lap[1].refresh_rate = "144 Hz";
        lap[1].display_size = "17 inches";
        lap[1].no_of_cores = 8;
        lap[1].processor = "AMD Ryzen 7 4800H";
        lap[1].lap_name = "TUF A15 2021";
        lap[1].ram_type = "DDR6";
        lap[1].type = "Gaming";
        lap[1].product_no = 2;

        lap[2].brand_name = "ASUS";
        lap[2].graphic_card = "GeForce RTX 3060Ti";
        lap[2].RAM = 16;
        lap[2].price = 125000;
        lap[2].windows_version = "Windows 11";
        lap[2].refresh_rate = "300 Hz";
        lap[2].display_size = "14 inches";
        lap[2].no_of_cores = 8;
        lap[2].processor = "Intel i-12 12th Generation";
        lap[2].lap_name = "ROG Zephyrus 2022";
        lap[2].ram_type = "DDR6";
        lap[2].type = "Gaming";
        lap[2].product_no = 3;

        lap[3].brand_name = "ASUS";
        lap[3].graphic_card = "NVIDIA GTX 1650";
        lap[3].RAM = 8;
        lap[3].price = 65000;
        lap[3].windows_version = "Windows 10 Pro";
        lap[3].refresh_rate = "90 Hz";
        lap[3].display_size = "15 inches";
        lap[3].no_of_cores = 4;
        lap[3].processor = "Intel i-7 10th Generation";
        lap[3].lap_name = "Vivo Book 2021";
        lap[3].ram_type = "DDR4";
        lap[3].type = "Non-Gaming";
        lap[3].product_no = 4;

        lap[4].brand_name = "ASUS";
        lap[4].graphic_card = "NVIDIA GTX 1650Ti";
        lap[4].RAM = 8;
        lap[4].price = 70000;
        lap[4].windows_version = "Windows 10 Pro";
        lap[4].refresh_rate = "120 Hz";
        lap[4].display_size = "17 inches";
        lap[4].no_of_cores = 4;
        lap[4].processor = "Intel i-7 10th Generation";
        lap[4].lap_name = "TUF F-15 2022";
        lap[4].ram_type = "DDR6";
        lap[4].type = "Non-Gaming";
        lap[4].product_no = 5;

        lap[5].brand_name = "ASUS";
        lap[5].graphic_card = "NVIDIA GTX 1650 Super";
        lap[5].RAM = 8;
        lap[5].price = 75000;
        lap[5].windows_version = "Windows 11";
        lap[5].refresh_rate = "144 Hz";
        lap[5].display_size = "17 inches";
        lap[5].no_of_cores = 8;
        lap[5].processor = "Intel i-7 12th Generation";
        lap[5].lap_name = "ZenBook 17 2022";
        lap[5].ram_type = "DDR6";
        lap[5].type = "Non-Gaming";
        lap[5].product_no = 6;

        lap[6].brand_name = "LENOVO";
        lap[6].graphic_card = "GeForce RTX 3050Ti";
        lap[6].RAM = 8;
        lap[6].price = 95000;
        lap[6].windows_version = "Windows 11";
        lap[6].refresh_rate = "144 Hz";
        lap[6].display_size = "15 inches";
        lap[6].no_of_cores = 8;
        lap[6].processor = "Intel i-7 12th Generation";
        lap[6].lap_name = "Legion Pro 2022";
        lap[6].ram_type = "DDR6";
        lap[6].type = "Gaming";
        lap[6].product_no = 1;

        lap[7].brand_name = "LENOVO";
        lap[7].graphic_card = "GeForce RTX 3050";
        lap[7].RAM = 8;
        lap[7].price = 85000;
        lap[7].windows_version = "Windows 11";
        lap[7].refresh_rate = "144 Hz";
        lap[7].display_size = "17 inches";
        lap[7].no_of_cores = 8;
        lap[7].processor = "AMD Ryzen 5 6800H";
        lap[7].lap_name = "IdeaPad Gaming 2021";
        lap[7].ram_type = "DDR6";
        lap[7].type = "Gaming";
        lap[7].product_no = 2;

        lap[8].brand_name = "LENOVO";
        lap[8].graphic_card = "GeForce RTX 3060Ti";
        lap[8].RAM = 16;
        lap[8].price = 100000;
        lap[8].windows_version = "Windows 11";
        lap[8].refresh_rate = "144 Hz";
        lap[8].display_size = "15 inches";
        lap[8].no_of_cores = 8;
        lap[8].processor = "AMD Ryzen 7 6800H";
        lap[8].lap_name = "Legion Ultra 2022";
        lap[8].ram_type = "DDR6";
        lap[8].type = "Gaming";
        lap[8].product_no = 3;

        lap[9].brand_name = "LENOVO";
        lap[9].graphic_card = "NVIDIA GTX 1650";
        lap[9].RAM = 8;
        lap[9].price = 60000;
        lap[9].windows_version = "Windows 10 Ultimate";
        lap[9].refresh_rate = "120 Hz";
        lap[9].display_size = "15 inches";
        lap[9].no_of_cores = 4;
        lap[9].processor = "Intel i-5 10th Generation";
        lap[9].lap_name = "Slim Pad 2020";
        lap[9].ram_type = "DDR4";
        lap[9].type = "Non-Gaming";
        lap[9].product_no = 4;

        lap[10].brand_name = "LENOVO";
        lap[10].graphic_card = "NVIDIA GTX 1650Ti";
        lap[10].RAM = 8;
        lap[10].price = 72000;
        lap[10].windows_version = "Windows 10 Pro";
        lap[10].refresh_rate = "120 Hz";
        lap[10].display_size = "15 inches";
        lap[10].no_of_cores = 8;
        lap[10].processor = "Intel i-7 10th Generation";
        lap[10].lap_name = "Yoga 360 Degree 2021";
        lap[10].ram_type = "DDR4";
        lap[10].type = "Non-Gaming";
        lap[10].product_no = 5;

        lap[11].brand_name = "LENOVO";
        lap[11].graphic_card = "NVIDIA GTX 1650Super";
        lap[11].RAM = 16;
        lap[11].price = 80000;
        lap[11].windows_version = "Windows 11";
        lap[11].refresh_rate = "144 Hz";
        lap[11].display_size = "15 inches";
        lap[11].no_of_cores = 6;
        lap[11].processor = "Intel i-7 12th Generation";
        lap[11].lap_name = "IdeaPad Slim 5 2021";
        lap[11].ram_type = "DDR6";
        lap[11].type = "Non-Gaming";
        lap[11].product_no = 6;

        lap[12].brand_name = "DELL";
        lap[12].graphic_card = "GeForce RTX 3050TI";
        lap[12].RAM = 16;
        lap[12].price = 99990;
        lap[12].windows_version = "Windows 11";
        lap[12].refresh_rate = "165 Hz";
        lap[12].display_size = "15 inches";
        lap[12].no_of_cores = 8;
        lap[12].processor = "Intel i-7 12th Generation";
        lap[12].lap_name = "G5 Gaming 2021";
        lap[12].ram_type = "DDR6";
        lap[12].type = "Gaming";
        lap[12].product_no = 1;

        lap[13].brand_name = "DELL";
        lap[13].graphic_card = "GeForce RTX 3050";
        lap[13].RAM = 8;
        lap[13].price = 86000;
        lap[13].windows_version = "Windows 11";
        lap[13].refresh_rate = "144 Hz";
        lap[13].display_size = "17 inches";
        lap[13].no_of_cores = 8;
        lap[13].processor = "Ryzen 7 4800H";
        lap[13].lap_name = "G15 Gaming 2022";
        lap[13].ram_type = "DDR6";
        lap[13].type = "Gaming";
        lap[13].product_no = 2;

        lap[14].brand_name = "DELL";
        lap[14].graphic_card = "GeForce RTX 3060Ti";
        lap[14].RAM = 16;
        lap[14].price = 99000;
        lap[14].windows_version = "Windows 11";
        lap[14].refresh_rate = "144 Hz";
        lap[14].display_size = "15 inches";
        lap[14].no_of_cores = 8;
        lap[14].processor = "Ryzen 5 5000 Octa";
        lap[14].lap_name = "Alien-Ware X DELL";
        lap[14].ram_type = "DDR6";
        lap[14].type = "Gaming";
        lap[14].product_no = 3;

        lap[15].brand_name = "DELL";
        lap[15].graphic_card = "NVIDIA GTX 1650";
        lap[15].RAM = 12;
        lap[15].price = 85000;
        lap[15].windows_version = "Windows 10 Ultimate";
        lap[15].refresh_rate = "120 Hz";
        lap[15].display_size = "15 inches";
        lap[15].no_of_cores = 4;
        lap[15].processor = "Intel i-5 10th Generation";
        lap[15].lap_name = "Inspiron Feel 2021";
        lap[15].ram_type = "DDR4";
        lap[15].type = "Non-Gaming";
        lap[15].product_no = 4;

        lap[16].brand_name = "DELL";
        lap[16].graphic_card = "NVIDIA GTX 1650Ti";
        lap[16].RAM = 8;
        lap[16].price = 55000;
        lap[16].windows_version = "Windows 10";
        lap[16].refresh_rate = "60 Hz";
        lap[16].display_size = "15 inches";
        lap[16].no_of_cores = 8;
        lap[16].processor = "Intel i-3 10th Generation";
        lap[16].lap_name = "Vostro 2020";
        lap[16].ram_type = "DDR4";
        lap[16].type = "Non-Gaming";
        lap[16].product_no = 5;

        lap[17].brand_name = "DELL";
        lap[17].graphic_card = "NVIDIA GTX 1650Super";
        lap[17].RAM = 16;
        lap[17].price = 80000;
        lap[17].windows_version = "Windows 11";
        lap[17].refresh_rate = "120 Hz";
        lap[17].display_size = "15 inches";
        lap[17].no_of_cores = 6;
        lap[17].processor = "Intel i-5 12th Generation";
        lap[17].lap_name = "MagicBook 2021";
        lap[17].ram_type = "DDR6";
        lap[17].type = "Non-Gaming";
        lap[17].product_no = 6;

        lap[18].brand_name = "MSI";
        lap[18].graphic_card = "GeForce RTX 3050TI";
        lap[18].RAM = 16;
        lap[18].price = 89500;
        lap[18].windows_version = "Windows 11";
        lap[18].refresh_rate = "165 Hz";
        lap[18].display_size = "15 inches";
        lap[18].no_of_cores = 8;
        lap[18].processor = "Intel i-7 12th Generation";
        lap[18].lap_name = "Katana GF76 2022";
        lap[18].ram_type = "DDR6";
        lap[18].type = "Gaming";
        lap[18].product_no = 1;

        lap[19].brand_name = "MSI";
        lap[19].graphic_card = "GeForce RTX 3050";
        lap[19].RAM = 8;
        lap[19].price = 110000;
        lap[19].windows_version = "Windows 11";
        lap[19].refresh_rate = "144 Hz";
        lap[19].display_size = "17 inches";
        lap[19].no_of_cores = 8;
        lap[19].processor = "Ryzen 7 4800H";
        lap[19].lap_name = "Katana 17 2022";
        lap[19].ram_type = "DDR6";
        lap[19].type = "Gaming";
        lap[19].product_no = 2;

        lap[20].brand_name = "MSI";
        lap[20].graphic_card = "GeForce RTX 3060Ti";
        lap[20].RAM = 8;
        lap[20].price = 99990;
        lap[20].windows_version = "Windows 11";
        lap[20].refresh_rate = "144 Hz";
        lap[20].display_size = "15 inches";
        lap[20].no_of_cores = 8;
        lap[20].processor = "Ryzen 5 5000 Octa";
        lap[20].lap_name = "Cross-Hair 15 2023";
        lap[20].ram_type = "DDR6";
        lap[20].type = "Gaming";
        lap[20].product_no = 3;

        lap[21].brand_name = "MSI";
        lap[21].graphic_card = "NVIDIA GTX 1650";
        lap[21].RAM = 12;
        lap[21].price = 88000;
        lap[21].windows_version = "Windows 10 Ultimate";
        lap[21].refresh_rate = "120 Hz";
        lap[21].display_size = "15 inches";
        lap[21].no_of_cores = 4;
        lap[21].processor = "Intel i-5 10th Generation";
        lap[21].lap_name = "Vector GP66";
        lap[21].ram_type = "DDR4";
        lap[21].type = "Non-Gaming";
        lap[21].product_no = 4;

        lap[22].brand_name = "MSI";
        lap[22].graphic_card = "NVIDIA GTX 1650Ti";
        lap[22].RAM = 8;
        lap[22].price = 67000;
        lap[22].windows_version = "Windows 10";
        lap[22].refresh_rate = "60 Hz";
        lap[22].display_size = "15 inches";
        lap[22].no_of_cores = 8;
        lap[22].processor = "Intel i-3 10th Generation";
        lap[22].lap_name = "Modern 15 2021";
        lap[22].ram_type = "DDR4";
        lap[22].type = "Non-Gaming";
        lap[22].product_no = 5;

        lap[23].brand_name = "MSI";
        lap[23].graphic_card = "NVIDIA GTX 1650Super";
        lap[23].RAM = 8;
        lap[23].price = 74000;
        lap[23].windows_version = "Windows 11";
        lap[23].refresh_rate = "120 Hz";
        lap[23].display_size = "15 inches";
        lap[23].no_of_cores = 6;
        lap[23].processor = "Intel i-5 12th Generation";
        lap[23].lap_name = "Cyborg 17 2021";
        lap[23].ram_type = "DDR6";
        lap[23].type = "Non-Gaming";
        lap[23].product_no = 6;

        lap[24].brand_name = "HP";
        lap[24].graphic_card = "GeForce RTX 3050TI";
        lap[24].RAM = 16;
        lap[24].price = 79990;
        lap[24].windows_version = "Windows 11";
        lap[24].refresh_rate = "144 Hz";
        lap[24].display_size = "15 inches";
        lap[24].no_of_cores = 8;
        lap[24].processor = "Intel i-5 12th Generation";
        lap[24].lap_name = "Pavillion Gaming 2022";
        lap[24].ram_type = "DDR6";
        lap[24].type = "Gaming";
        lap[24].product_no = 1;

        lap[25].brand_name = "HP";
        lap[25].graphic_card = "GeForce RTX 3050";
        lap[25].RAM = 16;
        lap[25].price = 99000;
        lap[25].windows_version = "Windows 11";
        lap[25].refresh_rate = "165 Hz";
        lap[25].display_size = "17 inches";
        lap[25].no_of_cores = 8;
        lap[25].processor = "Ryzen 7 6800H";
        lap[25].lap_name = "Pavillion Ultra 2022";
        lap[25].ram_type = "DDR6";
        lap[25].type = "Gaming";
        lap[25].product_no = 2;

        lap[26].brand_name = "HP";
        lap[26].graphic_card = "GeForce RTX 3060Ti";
        lap[26].RAM = 8;
        lap[26].price = 79990;
        lap[26].windows_version = "Windows 11";
        lap[26].refresh_rate = "120 Hz";
        lap[26].display_size = "15 inches";
        lap[26].no_of_cores = 8;
        lap[26].processor = "Ryzen 5 5000 Octa";
        lap[26].lap_name = "Victus Gaming 2022";
        lap[26].ram_type = "DDR6";
        lap[26].type = "Gaming";
        lap[26].product_no = 3;

        lap[27].brand_name = "HP";
        lap[27].graphic_card = "NVIDIA GTX 1650";
        lap[27].RAM = 8;
        lap[27].price = 70000;
        lap[27].windows_version = "Windows 10 Ultimate";
        lap[27].refresh_rate = "90 Hz";
        lap[27].display_size = "15 inches";
        lap[27].no_of_cores = 4;
        lap[27].processor = "Intel i-5 10th Generation";
        lap[27].lap_name = "15s Backlit 2021";
        lap[27].ram_type = "DDR4";
        lap[27].type = "Non-Gaming";
        lap[27].product_no = 4;

        lap[28].brand_name = "HP";
        lap[28].graphic_card = "NVIDIA GTX 1650Ti";
        lap[28].RAM = 8;
        lap[28].price = 69990;
        lap[28].windows_version = "Windows 10";
        lap[28].refresh_rate = "120 Hz";
        lap[28].display_size = "15 inches";
        lap[28].no_of_cores = 8;
        lap[28].processor = "Intel i-5 10th Generation";
        lap[28].lap_name = "Pavillion 14 2022";
        lap[28].ram_type = "DDR4";
        lap[28].type = "Non-Gaming";
        lap[28].product_no = 5;

        lap[29].brand_name = "HP";
        lap[29].graphic_card = "NVIDIA GTX 1650Super";
        lap[29].RAM = 8;
        lap[29].price = 49000;
        lap[29].windows_version = "Windows 11";
        lap[29].refresh_rate = "60 Hz";
        lap[29].display_size = "15 inches";
        lap[29].no_of_cores = 6;
        lap[29].processor = "Intel i-5 8th Generation";
        lap[29].lap_name = "Aspire 2021";
        lap[29].ram_type = "DDR4";
        lap[29].type = "Non-Gaming";
        lap[29].product_no = 6;
    }
    public void display(){
        System.out.println("=====================================================================================================================");
        System.out.println("|                                               SPECIFICATIONS!!!                                                   |");
        System.out.println("=====================================================================================================================");
        System.out.print(String.format("%-42s" , "|Laptop name: "+lap_name));
        System.out.print(String.format("%-33s" ,"No of cores: "+no_of_cores+" cores"));
        System.out.print(String.format("%-41s" ,"Refresh rate:: "+refresh_rate+""));
        System.out.println("|");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-42s" , "|Processor: "+processor));
        System.out.print(String.format("%-33s" , "RAM Size: "+RAM+" GB"));
        System.out.print(String.format("%-41s" ,"Display size: "+display_size+""));
        System.out.println("|");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-42s" ,"|Graphics card: "+graphic_card));
        System.out.print(String.format("%-33s" ,"RAM type: "+ram_type));
        System.out.print(String.format("%-41s" ,"Price: "+price+""));
        System.out.println("|");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                |Product key: "+product_no+"|");
        System.out.println();
        //System.out.println("==============================================================================================");
    }
    public void display2(newLap l[]){
        System.out.println("=====================================================================================================================");
        System.out.println("|                                          SPECIFICATIONS!!!                                                        |");
        System.out.println("=====================================================================================================================");
        System.out.print(String.format("%-60s" , "Laptop name: "+l[0].lap_name));
        System.out.println(String.format("%-50s" ,"Laptop name: "+l[1].lap_name));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "Processor: "+l[0].processor));
        System.out.println(String.format("%-50s" ,"Processor: "+l[1].processor));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "Graphic card: "+l[0].graphic_card));
        System.out.println(String.format("%-50s" ,"Graphic card: "+l[1].graphic_card));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "RAM Size: "+l[0].RAM+" GB"));
        System.out.println(String.format("%-50s" ,"RAM Size: "+l[1].RAM+" GB"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "Display Size: "+l[0].display_size));
        System.out.println(String.format("%-50s" ,"Display Size: "+l[1].display_size));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "RAM Type: "+l[0].ram_type));
        System.out.println(String.format("%-50s" ,"RAM Type: "+l[1].ram_type));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "Refresh rate: "+l[0].refresh_rate));
        System.out.println(String.format("%-50s" ,"Refresh rate: "+l[1].refresh_rate));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "No of cores: "+l[0].no_of_cores+" cores"));
        System.out.println(String.format("%-50s" ,"No of cores: "+l[1].no_of_cores+" cores"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "Price: "+l[0].price+" Ruppees"));
        System.out.println(String.format("%-50s" ,"Price: "+l[1].price+" Ruppees"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-60s" , "Product Key: "+l[0].product_no));
        System.out.println(String.format("%-50s" ,"Product Key: "+l[1].product_no));
    }
    public void display_config(){
        System.out.println("=====================================================================================================================");
        System.out.println("                                        SPECIFICATIONS!!!");
        System.out.println("=====================================================================================================================");
        System.out.print(String.format("%-30s" , ("Brand Name: "+brand_name)));
        System.out.print(String.format("%-35s" , "Laptop name: "+lap_name));
        System.out.println(String.format("%-35s" , "Graphics card: "+graphic_card));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-30s" , "RAM Size: "+RAM+" GB"));
        System.out.print(String.format("%-35s" , "Product key: "+product_no));
        System.out.println(String.format("%-35s" , "Processor: "+processor));

    }
    public void search_brand(newLap lap[]){
        System.out.println("The available Brands on our store are as BELOW: ");
        System.out.println("                                -----------------------------------");
        System.out.println("                                |1.ASUS|2.LENOVO|3.DELL|4.MSI|5.HP|");
        System.out.println("                                -----------------------------------");
        System.out.println("Enter your Choice by writing the Brand Name:");
        //s.nextLine();
        String choice = s.nextLine();
        if(choice.equalsIgnoreCase("ASUS") || choice.equalsIgnoreCase("DELL") || choice.equalsIgnoreCase("LENOVO") || choice.equalsIgnoreCase("MSI") || choice.equalsIgnoreCase("HP")){
            if(choice.equalsIgnoreCase("ASUS")){
               for(int i=0; i<30; i++){
                    if(lap[i].brand_name.equalsIgnoreCase("ASUS")){
                        lap[i].display();
                    }
                }
                brand_choice[0] = lap[0];
                brand_choice[1] = lap[1];
                brand_choice[2] = lap[2];
                brand_choice[3] = lap[3];
                brand_choice[4] = lap[4];
                brand_choice[5] = lap[5];
            }
            if(choice.equalsIgnoreCase("LENOVO")){
                for(int i=0; i<30; i++){
                    if(lap[i].brand_name.equalsIgnoreCase("LENOVO")){
                        lap[i].display();   
                    }
                }
                brand_choice[0] = lap[6];
                brand_choice[1] = lap[7];
                brand_choice[2] = lap[8];
                brand_choice[3] = lap[9];
                brand_choice[4] = lap[10];
                brand_choice[5] = lap[11];
            }
            if(choice.equalsIgnoreCase("DELL")){
                for(int i=0; i<30; i++){
                    if(lap[i].brand_name.equalsIgnoreCase("DELL")){
                        lap[i].display();
                    }
                }
                brand_choice[0] = lap[12];
                brand_choice[1] = lap[13];
                brand_choice[2] = lap[14];
                brand_choice[3] = lap[15];
                brand_choice[4] = lap[16];
                brand_choice[5] = lap[17];
            }
            if(choice.equalsIgnoreCase("MSI")){
                for(int i=0; i<30; i++){
                    if(lap[i].brand_name.equalsIgnoreCase("MSI")){
                        lap[i].display();
                    }
                }
                brand_choice[0] = lap[18];
                brand_choice[1] = lap[19];
                brand_choice[2] = lap[20];
                brand_choice[3] = lap[21];
                brand_choice[4] = lap[22];
                brand_choice[5] = lap[23];
            }
            if(choice.equalsIgnoreCase("HP")){
                for(int i=0; i<30; i++){
                    if(lap[i].brand_name.equalsIgnoreCase("HP")){
                        lap[i].display();
                    }
                }
                brand_choice[0] = lap[24];
                brand_choice[1] = lap[25];
                brand_choice[2] = lap[26];
                brand_choice[3] = lap[27];
                brand_choice[4] = lap[28];
                brand_choice[5] = lap[29];
            }
        }
        else{
            search_brand(lap);
        }
        System.out.println("Do you want to finalize the laptop or want to compare two of the above Laptops!!!");
        System.out.println("1.For Finalizing!!\n2.For comparing two laptops!!!");
        boolean bool = true;
        while(bool){
            int cho = s.nextInt();
            boolean f = true;
            while(f){
                if(cho==1 || cho==2){
                    switch(cho){
                        case 1:
                        fin = finalize(brand_choice);
                        System.out.println("You have finalized this laptop!!!!");
                        fin.display();
                        bill(fin);
                        bool=false;
                        break;
                        case 2:
                        newLap comp[] = compare_two(brand_choice);
                        comp[0].display2(comp);
                        fin = finalize(comp);
                        System.out.println("You have finalized this laptop!!!!");
                        fin.display();
                        bill(fin);
                        bool=false;
                        break;
                        default:
                        bool = false;
                        break;
                    }
                }
                else{
                    System.out.println("Enter valid choice!!!!!");
                    break;
                }
                break;
            }
        }
    }
    public newLap finalize(newLap lap[]){
        //System.out.println("Enter the product key of the Laptop for finalizing!!!");
        //int choicee = s.nextInt();
        newLap finals = new newLap();
        boolean f = true;
        boolean e = true;
        boolean g = true;
        while(f && lap.length==2){
            System.out.println("Enter the product key of the Laptop for finalizing!!!");
            int choicee = s.nextInt();
            if(lap.length==2 && (choicee==choice1[0] || choicee==choice1[1])){
                for(int i=0; i<2; i++){
                    if(choicee==lap[i].product_no){
                        finals = lap[i];
                        f = false;
                        break;
                    }
                }
            }
            else{
                System.out.println("Enter valid product key!!!!!");
            }
        }
        while(e && lap.length==6){
            System.out.println("Enter the product key of the Laptop for finalizing!!!");
            int choicee = s.nextInt();
            if(lap.length==6  && choicee<=6){
                for(int i=0; i<6; i++){
                    if(choicee==lap[i].product_no){
                        finals = lap[i];
                        break;
                    }
                }
            }
            else{
                System.out.println("Enter valid product key!!!!");
                break;
            }
            break;
        }
        while(g && lap.length==3){
            s.nextLine();
            System.out.println("Enter brand name for finalizing!!!");
            String brand_n = s.nextLine();
            System.out.println("Enter the product key of the Laptop for finalizing!!!");
            int choicee = s.nextInt();
            if(choicee==choic1[0] || choicee==choic1[1] || choicee==choic1[2]){
                for(int i=0; i<3; i++){
                    if(choicee==lap[i].product_no && brand_n.equalsIgnoreCase(lap[i].brand_name)){
                        finals = lap[i];
                        break;
                    }
                }
            }
            else{
                System.out.println("Enter valid product key!!!!");
                break;
            }
            break;
        }
        return finals;
    }
    newLap compare[] = new newLap[2];
    public newLap[] compare_two(newLap lap[]){
        boolean flag = true;
        while(flag){
            System.out.print("Enter First Laptop Product Key: ");
            choice1[0] = s.nextInt();
            System.out.print("Enter Second Laptop Product Key: ");
            choice1[1] = s.nextInt();
            for(int i=0; i<2; i++){
                compare[i] = new newLap();
            }
            if(choice1[0]<=6 && choice1[1]<=6){
                for(int i=0; i<lap.length; i++){
                    if(choice1[0]==lap[i].product_no){
                        compare[0] = lap[i];
                    }
                    if(choice1[1]==lap[i].product_no){
                        compare[1] = lap[i];
                    }
                    flag = false;
                }
            }
            else{
                System.out.println("Enter choice of product key between 1 to 6!!!!");
                compare_two(lap);
                flag = false;
            }
        }
        return compare;
    }
    public newLap[] by_budget(newLap lap[]){
        System.out.println("Enter your budget: ");
        int budget = s.nextInt();
        //s.nextLine();
        for(int i=0; i<30; i++){
            if(lap[i].price<=budget){
                lap[i].display_config();
            }
        }
        newLap compare[] = new newLap[3];
        for(int i=0; i<compare.length; i++){
            compare[i] = new newLap();
        }
        System.out.println("Enter Any three laptops for viewing!!!!!");
        String choice[] = new String[3];
        //choic1[] = new int[3];
        System.out.println("Enter Brand name and product key for Viewing!!!!!");  
        System.out.print("Enter First Laptop brand name: ");
        s.nextLine();
        choice[0] = s.nextLine();
        System.out.print("Enter First Laptop Product Key: ");
        choic1[0] = s.nextInt();
        System.out.print("Enter Second Laptop brand name: ");
        s.nextLine();
        choice[1] = s.nextLine();
        System.out.print("Enter Second Laptop Product Key: ");
        choic1[1] = s.nextInt();
        System.out.print("Enter Third Laptop brand name: ");
        s.nextLine();
        choice[2] = s.nextLine();
        System.out.print("Enter Third Laptop Product Key: ");
        choic1[2] = s.nextInt();
        for(int i=0; i<30; i++){
            if(choice[0].equalsIgnoreCase(lap[i].brand_name)){
                if(choic1[0]==lap[i].product_no){
                    compare[0] = lap[i];
                }
            }
            if(choice[1].equalsIgnoreCase(lap[i].brand_name)){
                if(choic1[1]==lap[i].product_no){
                    compare[1] = lap[i];
                }
            }
            if(choice[2].equalsIgnoreCase(lap[i].brand_name)){
                if(choic1[2]==lap[i].product_no){
                    compare[2] = lap[i];
                }
            }
        }
        return compare;
    }
    public newLap[] Gaming(newLap lap[]){
        for(int i=0; i<30; i++){
            if(lap[i].type.equalsIgnoreCase("GAMING")){
                lap[i].display();
            }
        }
        newLap compare[] = new newLap[3];
        for(int i=0; i<compare.length; i++){
            compare[i] = new newLap();
        }
        System.out.println("Enter Any three laptops for viewing!!!!!");
        String choice[] = new String[3];
        //int choice1[] = new int[3];
        boolean flag = true;
        while(flag){
            System.out.println("Enter Brand name and product key for Viewing!!!!!");  
            System.out.print("Enter First Laptop brand name: ");
            choice[0] = s.nextLine();
            System.out.print("Enter First Laptop Product Key: ");
            choic1[0] = s.nextInt();
            System.out.print("Enter Second Laptop brand name: ");
            s.nextLine();
            choice[1] = s.nextLine();
            System.out.print("Enter Second Laptop Product Key: ");
            choic1[1] = s.nextInt();
            System.out.print("Enter Third Laptop brand name: ");
            s.nextLine();
            choice[2] = s.nextLine();
            System.out.print("Enter Third Laptop Product Key: ");
            choic1[2] = s.nextInt();
            for(int j=0; j<3; j++){
                if(choic1[j]>0 && choic1[j]<=3){
                    for(int i=0; i<30; i++){
                        if(choice[0].equalsIgnoreCase(lap[i].brand_name)){
                            if(choic1[0]==lap[i].product_no){
                                compare[0] = lap[i];
                            }
                        }
                        if(choice[1].equalsIgnoreCase(lap[i].brand_name)){
                            if(choic1[1]==lap[i].product_no){
                                compare[1] = lap[i];
                            }
                        }
                        if(choice[2].equalsIgnoreCase(lap[i].brand_name)){
                            if(choic1[2]==lap[i].product_no){
                                compare[2] = lap[i];
                            }
                        }
                    }
                }
                else{
                    System.out.println("Enter valid product key or brand name!!!!!");
                }
            }
            break;
        }
        return compare;
    }
    public newLap[] Non_Gaming(newLap lap[]){
        for(int i=0; i<30; i++){
            if(lap[i].type.equalsIgnoreCase("NON-GAMING")){
                lap[i].display();
            }
        }
        newLap compare[] = new newLap[3];
        for(int i=0; i<compare.length; i++){
            compare[i] = new newLap();
        }
        System.out.println("Enter Any three laptops for viewing!!!!!");
        String choice[] = new String[3];
        //int choice1[] = new int[3];
        boolean flag = true;
        while(flag){
            System.out.println("Enter Brand name and product key for Viewing!!!!!");  
            System.out.print("Enter First Laptop brand name: ");
            choice[0] = s.nextLine();
            System.out.print("Enter First Laptop Product Key: ");
            choic1[0] = s.nextInt();
            System.out.print("Enter Second Laptop brand name: ");
            s.nextLine();
            choice[1] = s.nextLine();
            System.out.print("Enter Second Laptop Product Key: ");
            choic1[1] = s.nextInt();
            System.out.print("Enter Third Laptop brand name: ");
            s.nextLine();
            choice[2] = s.nextLine();
            System.out.print("Enter Third Laptop Product Key: ");
            choic1[2] = s.nextInt();
            for(int j=0; j<3; j++){
                if(choic1[j]>3 && choic1[j]<=6){
                    for(int i=0; i<30; i++){
                        if(choice[0].equalsIgnoreCase(lap[i].brand_name)){
                            if(choic1[0]==lap[i].product_no){
                                compare[0] = lap[i];
                            }
                        }
                        if(choice[1].equalsIgnoreCase(lap[i].brand_name)){
                            if(choic1[1]==lap[i].product_no){
                                compare[1] = lap[i];
                            }
                        }
                        if(choice[2].equalsIgnoreCase(lap[i].brand_name)){
                            if(choic1[2]==lap[i].product_no){
                                compare[2] = lap[i];
                            }
                        }
                    }
                }
                else{
                    System.out.println("Enter valid product key or brand name!!!!!");
                }
            }
            break;
        }
        return compare;
    }
    public void bill(newLap lap){
        long price = lap.price;
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                    BILL!!!!");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.print(String.format("%-27s" ," "));
        System.out.println("---------------------------------------------------------");
        System.out.print(String.format("%-27s" ," "));
		System.out.println("|| Description of Goods |   MRP   |   CGST   |   SGST   ||");
        System.out.print(String.format("%-27s" ," "));
		System.out.println("---------------------------------------------------------");
        System.out.print(String.format("%-27s" ," "));
        System.out.print("||");
        System.out.print(String.format("%-22s" ,""+lap.lap_name));
        System.out.print(String.format("%-3s" ,"|"));
        System.out.print(String.format("%-7s" ,""+lap.price));
        System.out.print(String.format("%-3s" ,"|"));
        double gst = lap.price * 0.18;
        System.out.print(String.format("%-8s" ,""+gst));
        System.out.print(String.format("%-3s" ,"|"));
        System.out.print(String.format("%-8s" ,""+gst));
        System.out.println(String.format("%-3s" ,"||"));
        System.out.print(String.format("%-27s" ," "));
        System.out.println("---------------------------------------------------------");
        System.out.print(String.format("%-27s" ," "));
        System.out.print("||");
        System.out.print(String.format("%-46s" ,"Final Amount:"));
        double total = price +gst+gst;
        System.out.println(total+"||");
        System.out.print(String.format("%-27s" ," "));
        System.out.println("---------------------------------------------------------");
    }
}   