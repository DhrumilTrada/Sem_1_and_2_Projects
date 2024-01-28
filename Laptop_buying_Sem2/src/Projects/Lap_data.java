package Projects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Lap_data {
        String graphic_card, windows_version, display_size, refresh_rate;
        int RAM, no_of_cores, product_no;
        long price;
        String processor, ram_type, lap_name, type, brand_name;
        Lap_data lap[] = new Lap_data[30];

        public void setData(Lap_data lap[]) {
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
                lap[4].price = 56000;
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
                lap[5].price = 66000;
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
                lap[11].price = 54000;
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
                lap[15].price = 45000;
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
                lap[17].price = 60000;
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
                lap[21].price = 70000;
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
                lap[27].price = 45000;
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

        public String toString(int a) {
                System.out.println("===============================================================================================================");
                System.out.println("\u001B[31m"+"|                                            SPECIFICATIONS!!!"+"                                                |"+"\u001B[m");
                System.out.println("===============================================================================================================");
                System.out.print(String.format("%-37s", "|Brand Name: " + brand_name));
                System.out.print(String.format("%-47s", "|Graphics card: " + graphic_card));
                System.out.print(String.format("%-26s", "|RAM Size: " + RAM + " GB"));
                System.out.println("|");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                System.out.print(String.format("%-37s", "|Laptop name: " +lap_name));
                System.out.print(String.format("%-47s", "|Processor: " + processor));
                System.out.print(String.format("%-26s", "|Product key: " + product_no));
                System.out.println("|");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                return " ";
        }

        public void create_File(String filename, int i) throws IOException{
                String ss[] = new String[4];
                ss[0] = "|Laptop name:" +lap_name+"             No of cores:"+no_of_cores+"              Refresh rate:"+refresh_rate+"|";
                ss[1] = "|Processor:"+processor+"          RAM Size:"+RAM+"            Display size:"+display_size+"|";
                ss[2] = "|Graphics card:"+graphic_card+"        RAM type:"+ram_type+"   Price:"+price+"|";
                ss[3] = "                               Product Key: "+product_no;
                FileWriter fw = new FileWriter(new File(filename+"_"+i+".txt"));
                BufferedWriter bw = new BufferedWriter(fw);
                for(String s: ss){
                        bw.write(s);
                        bw.newLine();
                }
                bw.close();
        }

        public String toString() {
                System.out.println("===============================================================================================================");
                System.out.println("\u001B[31;1m"+"|                                            SPECIFICATIONS!!!"+"                                                |"+"\u001B[m");
                System.out.println("===============================================================================================================");
                System.out.print(String.format("%-46s", "|Laptop name: " + lap_name));
                System.out.print(String.format("%-31s", "No of cores: " + no_of_cores +"cores"));
                System.out.print(String.format("%-33s", "Refresh rate:: " + refresh_rate));
                System.out.println("|");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                System.out.print(String.format("%-46s", "|Processor: " + processor));
                System.out.print(String.format("%-31s", "RAM Size: " + RAM + " GB"));
                System.out.print(String.format("%-33s", "Display size: " + display_size + ""));
                System.out.println("|");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                System.out.print(String.format("%-46s", "|Graphics card: " + graphic_card));
                System.out.print(String.format("%-31s", "RAM type: " + ram_type));
                System.out.print(String.format("%-33s", "Price: " + price + ""));
                System.out.println("|");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                System.out.println("                                       |Brand Name: "+brand_name+"  Product key: " + product_no + "|");
                System.out.println();
                return "";
        }
        public double bill(Lap_data lap){
                long price = lap.price;
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                System.out.println("\u001B[31m"+"                                                    BILL!!!!"+"\u001B[0m");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
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
                return total;
            }

        public Lap_data put(int i, Lap_data remove) {
            return null;
        }
}