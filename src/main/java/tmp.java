import java.util.concurrent.ThreadLocalRandom;

public class tmp {
    private static String [] names = {"Essential PH-1","Pixel/XL", "Pixel 2/XL","Pixel 3/XL","Pixel 3a/XL","Pixel 4/XL","HTC Dream","HTC Magic","HTC Hero","HTC Desire","Huawei P10","Realme 3 PRO","Huawei P20","Huawei P30","LG G2","LG G3","LG G4","LG G5","LG G6","LG G7 ThinQ","LG G8 ThinQ","LG Optimus G","LG V10","LG V20","LG V30","LG V35 ThinQ","LG V40 ThinQ","LG V50 ThinQ","Meizu MX4","Meizu MX4 Pro","Meizu MX5","Meizu MX6","Meizu PRO 5","Meizu PRO 6","Moto C","Moto E3","Moto E4","Moto E5","Moto E (1st generation)","Moto E (2nd generation)","Moto G4","Moto G5","Moto G6","Moto G7","Moto G (1st generation)","Moto G (2nd generation)","Moto G (3rd generation)","Motorola Photon Q","Moto X4","Moto X (1st generation)","Moto X (2nd generation)","Moto X Play","Moto X Style","Moto Z","Moto Z Play","Moto Z2 Force","Moto Z2 Play","Moto Z3 Force","Moto Z3 Play","Moto Z4","Nextbit Robin","Nexus One","Nexus S","Galaxy Nexus","Nexus 4","Nexus 5","Nexus 6","Nexus 5X","Nexus 6P","Nokia X","Nokia X2","Nokia 1","Nokia 1 Plus","Nokia C1","Nokia 2","Nokia 2.1","Nokia 2.2","Nokia 2.3","Nokia 3","Nokia 3.1","Nokia 3.1 Plus","Nokia 3.2","Nokia 4.2","Nokia 5","Nokia 5.1","Nokia 5.1 Plus","Nokia 6","Nokia 6.1","Nokia 6.1 Plus","Nokia 6.2","Nokia 7","Nokia 7 Plus","Nokia 7.1","Nokia 7.2","Nokia 8","Nokia 8 Sirocco","Nokia 8.1","Nokia 9 PureView","OnePlus One","OnePlus 2","OnePlus X","OnePlus 3","OnePlus 3T","OnePlus 5","OnePlus 5T","OnePlus 6","OnePlus 6T","OnePlus 7","OnePlus 7 Pro","OnePlus 7T","OnePlus 7T Pro","Panasonic P100","Samsung Galaxy","Samsung Galaxy S1","Samsung Galaxy S2","Samsung Galaxy S3","Samsung Galaxy S4","Samsung Galaxy S4 Zoom","Samsung Galaxy S5","Samsung Galaxy S6/Edge","Samsung Galaxy S6 Edge+","Samsung Galaxy Grand Prime","Samsung Galaxy S7/Edge","Samsung Galaxy S8/+","Samsung Galaxy S9/+","Samsung Galaxy S10/e/+","Samsung Galaxy S10 5G","Samsung Galaxy Note","Samsung Galaxy Note 2","Samsung Galaxy Note 3","Samsung Galaxy Note 3 Neo","Samsung Galaxy Note 4/Edge","Samsung Galaxy Note 5","Samsung Galaxy Note 7","Samsung Galaxy Note FE","Samsung Galaxy Note 8","Samsung Galaxy Note 9","Samsung Galaxy Note 10/+","Sony Ericsson Xperia Play","Sony Ericsson Xperia pro","Sony Xperia X/Performance","Sony Xperia X Compact","Sony Ericsson Xperia X10","Sony Ericsson Xperia X8","Sony Xperia 1","Sony Xperia 5","Sony Xperia 8","Sony Xperia 10/Plus","Sony Xperia XZ","Sony Xperia XZs/Premium","Sony Xperia XZ1/Compact","Sony Xperia XZ2/Compact","Sony Xperia XZ2 Premium","Sony Xperia XZ3","Sony Xperia Z","Sony Xperia Z Ultra","Sony Xperia Z1","Sony Xperia Z1 Compact","Sony Xperia Z2","Sony Xperia Z3/Compact","Sony Xperia Z4","Sony Xperia Z5/Compact","Sony Xperia Z5 Premium","Xiaomi Mi 1","Xiaomi Mi 2","Xiaomi Mi 2S/A","Xiaomi Mi MIX Alpha"};
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("insert into products (name, description, price, count) values");
        for (int i = 0; i < names.length; i++) {
            sb.append("('");
            sb.append(names[i]);
            sb.append("', '");
            sb.append("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda beatae ducimus ex nihil nisi officiis pariatur quibusdam! Natus non, possimus? At doloribus dolorum natus, neque obcaecati quasi repellendus sit voluptatum?");
            sb.append("', ");
            sb.append(ThreadLocalRandom.current().nextInt(100, 300));
            sb.append(", ");
            sb.append(ThreadLocalRandom.current().nextInt(0, 100));
            sb.append("),\n");
        }
        System.out.println(sb.toString());

    }
}
