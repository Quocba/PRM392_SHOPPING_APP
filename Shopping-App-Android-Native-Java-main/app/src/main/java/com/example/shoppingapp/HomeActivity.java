package com.example.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    RecyclerView rv;
    public static final String PRODUCT_KEY = "product_key";
    private static final int PERMISSION_REQ_COD = 1;
    public static final String TABLE_NAME_KEY = "table_key";
    SharedPreferences shp;
    SharedPreferences.Editor shpEditor;
    SharedPreferences shp_id;
    SharedPreferences.Editor shpEditor_id;
    public static boolean flag;
    ShoppingDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        flag = false;
        db = new ShoppingDatabase(this);
        // int image, String name, double price, String brand, int pieces, String description, double discount, float rating

        // Mobile
        Products p1 = new Products(R.drawable.mobile1,"Samsung Galaxy Note 8",174.62,"Samsung",8,"Screen size: 6.3 inches. Supports 2 sims: Yes. Ram: 6GB. Battery: 3300 mAh. Chip: Exynos 8895. Camera: 12MP. Screen resolution: 2960×1440. Screen panel: Super AMOLED. Corning Gorilla Glass 5 touch screen. Video recording: 4K 2160@24fps. Flash: LED Flash. Features: Optical image stabilization (OIS), autofocus, touch focus, face detection, HDR, bokeh photography, Zoom mode (Dual Camera)...",5,(float) 4.0);
        db.insertProduct(p1,ShoppingDatabase.TB_MOBILE);

        Products p2 = new Products(R.drawable.mobile2,"Nokia X6 Vivo V9",59.38,"Nokia",8,"Nokia X6 has a 5.8-inch edge-to-edge screen, 1,080 × 2,280 resolution (19:9 ratio), IPS LCD technology. It's no exaggeration to say this is one of the screens with the best display quality in the segment. The device is equipped with a good configuration using Snapdragon 636 chip with 6GB RAM/ 64GB internal memory, has an expansion card slot and runs Android 9 operating system. The device runs fast, smoothly and with little lag even if used for a whole week without needing to reboot. The Nokia X6's rear cameras have 16MP resolution and f/2.0 aperture. These two cameras are equipped with dual LED flash, support phase-detection focus, background blur photography, and Full HD video recording. 16MP selfie camera, f/2.0, can be combined with the rear camera to take photos and record videos at the same time through the bothie feature.",5,(float) 4.0);
        db.insertProduct(p2,ShoppingDatabase.TB_MOBILE);

        Products p3 = new Products(R.drawable.mobile3,"Iphone 13 Pro Max",1099.01,"Apple",8,"The iPhone 13 Pro Max has a compact design for comfortable holding. Regarding screen specifications, the phone is equipped with a screen with a resolution of 2556 x 1179 pixels and a pixel density of 2556 x 1179 pixels, providing impressive display capabilities. he phone is equipped with a super impressive Dynamic Island screen with the ability to transform into many shapes according to user control. Thanks to that, users can quickly monitor and display information such as calls, directions, timers,... On the iPhone 13 Pro Max, for the first time Apple equips its product with a large sensor camera. Accordingly, the device has upgraded the main camera to 48MP resolution, combined with pixel-pinning technology to help improve the ability to take photos in low light conditions. Product set includes: Phone, Charging cord, User manual 12 month electronic warranty.",20,(float) 4.9);
        db.insertProduct(p3,ShoppingDatabase.TB_MOBILE);

        // Laptop
        Products p4 = new Products(R.drawable.laptop1,"Laptop MSI GAMING BRAVO 15 B5DD-279VN AMD R5(5600)/ 8GB/ SSD 512GB/ VGA RX5500 4GB/ 15,6” FHD, IPS/",834.03,"Laptop Gaming",20,"Laptop: Msi Bravo 15 B5DD 279VN. CPU: AMD Ryzen™ R5-5600H (3.3GHz upto 4.2GHz, 6 Cores, 12 Threads, 16MB Cache). RAM: 8GB DDR4 3200MHz (2 slots). Hard drive: 512GB M.2 PCIe SSD (1 slot). CD/DVD: None. Card: VGA AMD Radeon™ RX 5500M with 4GB GDDR6. Screen: 15.6-inch FHD (1920x1080), IPS panel, thin bezel, anti-glare. Connection: Wi-Fi 6 + Bluetooth 5.1. Integrated: 1x Type-A USB2.0, 1x RJ45, 1x (4K @ 60Hz) HDMI, 1x Type-C USB3.2 Gen1, 2x Type-A USB3.2 Gen1, 1x Mic-in/Headphone-out Combo Jack. Webcam HD type (30fps@720p). Keyboard: Backlight Keyboard (Single-Color, Red). Battery: 3 Cell, 53.5 WHrs Li-ion Battery. Weight: 2.35 kg. Dimensions: 359 x 254 x 24.95 mm (Length x Width x Thickness). Operating system: Windows 11 license. Color: Black. Condition: 100% new, genuine product, full accessories. Warranty period: Genuine 12-month warranty at MSI Insurance Center nationwide.",0,(float) 3.0);
        db.insertProduct(p4,ShoppingDatabase.TB_LAPTOP);

        Products p5 = new Products(R.drawable.laptop2,"Laptop Asus ROG Strix G16 G614JU-N3777W (Intel® Core™ i7-13650HX & RTX 4050 6GB)",1627.76,"Laptop Gaming",10,"CPU: Intel® Core™ i7-13650HX Processor (upto 4.90 GHz, 24MB). RAM: 16GB DDR5-4800 SO-DIMM (2 slots, maximum 32GB). Hard drive: 512GB PCIe 4.0 NVMe M.2 SSD. VGA: NVIDIA® GeForce RTX 4050 6GB GDDR6. Screen: 16 inch FHD+ 16:10 (1920 x 1200, WUXGA), 165Hz, 7ms IPS-level, 250nits, 1000:1, anti-glare display. Battery: 4-cell, 90WHrs. Weight: 2.50 Kg. Feature: RGB Led keyboard backlight. Color: Eclipse Gray. OS: Windows 11 Home. Warranty: 24 months.",0,(float) 4.0);
        db.insertProduct(p5,ShoppingDatabase.TB_LAPTOP);

        Products p6 = new Products(R.drawable.laptop3,"Laptop Acer Nitro 5 AN515-45 GTX1650 R5-5600H 8GB 512GB 15.6'144Hz",976.49,"Laptop Gaming",8,"CPU: AMD Ryzen 5 5600H 3.3GHz up to 4.2GHz 16MB. RAM: 8GB DDR4 3200MHz (2x SO-DIMM sockets, up to 64GB SDRAM). Hard drive: 512GB M.2 PCIE SSD (1 M.2 PCIE SSD slot and 1 2.5\" SATA slot available). Graphics card: NVIDIA GeForce GTX 1650 4GB GDDR6 + AMD Radeon™ Graphics. Screen: 15.6\" FHD (1920 x 1080) IPS, 144Hz, Acer ComfyViewTM LED-backlit TFT LCD, 65% sRGB. Interface ports: 1x USB 3.2 Gen 2 Type-C Ports (up to 10 Gbps), 1x USB 3.2 Gen 2 Type-A Ports, 2x USB 3.2 Gen 1 Type-A Ports. Interface ports: 1x USB 3.2 Gen 2 Type-C Ports (up to 10 Gbps), 1x USB 3.2 Gen 2 Type-A Ports, 2x USB 3.2 Gen 1 Type-A Ports 1x RJ45, 1x HDMI® 2.0 port with HDCP support, 1 x 3.5 mm headphone/speaker jack, supporting headsets with built-in microphone. Optical drive: None. Audio DTS® X: Ultra Audio, Acer TrueHarmony™. Led-Keyboard: RGB 4 Zone. Read memory card: None. LAN standard: 10/100/1000/Gigabits Base T. WIFI standard: 802.11AX (2x2). Bluetooth: v5.0. Webcam: HD Webcam. Operating system: Windows 11 Home. Battery: 4 Cell 57WHr. Weight: 2.20 kg. Color: Black. Dimensions: 363.4 x 255 x 23.9 mm.",10,(float) 4.5);
        db.insertProduct(p6,ShoppingDatabase.TB_LAPTOP);

        // Fashion
        Products p7 = new Products(R.drawable.fashion1,"DirtyCoins Linen Graffiti Shirt",19.94,"Dirty Coin",20,"Linen fabric with DirtyCoins printed on the left chest of the shirt. Black collar trim. Right breast implant. Loose shape, creating a comfortable feeling when wearing. Buttoned 'V' neck.",5,(float) 4.0);
        db.insertProduct(p7,ShoppingDatabase.TB_FASHION);

        Products p8 = new Products(R.drawable.fashion2,"Men's Turn-down Collar T-shirt - Men's Cotton Crocodile Fabric Polo Shirt APL2",28.49,"LaDos",20,"Thick fabric, good elasticity and importantly high color fastness. Washes without shedding or discoloration, absorbs sweat and is comfortable without being restrictive when exercising. Open structure design, large fabric eyes create coolness for the wearer.",5,(float) 4.5);
        db.insertProduct(p8,ShoppingDatabase.TB_FASHION);

        Products p9 = new Products(R.drawable.fashion3,"DirtyCoins Skeleton Bowling Shirt",18.31,"Dirty Coin",20,"Linen fabric with DirtyCoins printed on the left chest of the shirt. Has a logo image on the chest. Loose shape, creating a comfortable feeling when wearing. Buttoned 'V' neck.",10,(float) 4.0);
        db.insertProduct(p9,ShoppingDatabase.TB_FASHION);

        // Electronic
        Products p10 = new Products(R.drawable.electronic1,"LG Inverter 1 HP V10WIN air conditioner",427.12,"LG",100,"LG Inverter 1 HP V10WIN air conditioner is a good cooling device with the ability to cool quickly with Jet Cool technology, operate stably, save electricity with Dual Inverter technology, Energy Ctrl, and has a self-cleaning function, on-off timer, night sleep mode to avoid cold for you to use the machine conveniently, cooling effectively.",5,(float) 4.0);
        db.insertProduct(p10,ShoppingDatabase.TB_ELECTRICS);

        Products p11 = new Products(R.drawable.electronic2,"Sunhouse SHD7746 air conditioning fan",203.18,"Sunhouse",100,"Sunhouse SHD7746 air conditioning fan with 2 pieces of dry ice quickly reduces heat, increasing cooling ability. When using, fill the ice bottle with water and put it in the freezer compartment, then take it out and put it in the dry ice compartment in the fan and use it like regular dry ice.",8,(float) 4.0);
        db.insertProduct(p11,ShoppingDatabase.TB_ELECTRICS);

        // Home and cooker
        Products p12 = new Products(R.drawable.home_and_cooker1,"Sharp 1.8 liter electronic rice cooker KS-COM194EV-BK",80.99,"Sharp",50,"Sharp 1.8 liter electronic rice cooker KS-COM194EV-BK has a non-stick coating inside the pot to help cook rice deliciously, keep warm well, with a variety of pre-installed programs for many different types of rice, keeping warm for up to 24 hours conveniently.",5,(float) 4.0);
        db.insertProduct(p12,ShoppingDatabase.TB_HOME_COOKER);

        Products p13 = new Products(R.drawable.home_and_cooker2,"Sunhouse SHD4026 6 liter oil-free fryer",116.00,"Sunhouse",20,"Sharp 1.8 liter electronic rice cooker KS-COM194EV-BK has a total capacity of 8 liters, a usable capacity of 6 liters, suitable for use in families of 5-6 members. Use to prepare dishes such as french fries, whole grilled chicken 1.5 kg or 2 pieces of ribs 0.5 kg at the same time, delicious and prepared for family meals.",5,(float) 4.0);
        db.insertProduct(p13,ShoppingDatabase.TB_HOME_COOKER);

        // Game
        Products p14 = new Products(R.drawable.game1,"PXN 9609 Bluetooth Form Xbox Wireless GamePad for PC / PS3 / Android / iOS 15 / Switch with Vibration",24.01,"Xbox",30,"Support Windows XP / Vista / 7 / 8 / 10 PC, Laptop, Android Phone, iPhone / iPad (iOS) / Nintendo Switch by Bluetooth. For Android TV devices, a USB RECEIVER is required (purchased separately). Using BlueTooth 4.0 wireless technology, freely operate without delay within a range of 8 meters. Dual Motor side vibration, precise action buttons and ergonomically designed structure will give you a much more comfortable gaming experience. Built-in 550mAh Lithium Ion battery and smart energy saving design, turns off when not in use after a period of time. Game Time of 20 hours & charging time of 3 hours - Supports two players at the same time - Wireless connection via 2.4G wifi USB signal head (Note: do not connect via Bluetooth). Connection distance up to 8m - Color: Black. HIGHLIGHTS: - Compatible on many platforms and devices: (Window) PC & Laptop, Android & iOS Phone/ Nintendo Switch / Playstation 3.",5,(float) 4.5);
        db.insertProduct(p14,ShoppingDatabase.TB_GAME);

        Products p15 = new Products(R.drawable.game2,"PXN P3 Bluetooth Wireless form XBOX controller for iOS / Android / PC / Laptop / TV",24.01,"Xbox",25,"GamePad Wireless GamePad PXN P3 Gray Bluetooth Wireless Gaming for iPhone / iPad / iOS / Android / PC / Laptop - With vibration. PXN P3 controller plays FIFA ONLINE 4, PES and supports MANY other popular PC games such as GTA, NFS, etc. Model: PXN P3 Gray & Blue GamePad. Connection Mode: Wireless Bluetooth (For phones, PC connection requires included USB Receiver). Transmission Range: Approx. 7 M (23 Ft). Standard Temperature: 10 To 40 °C (50 To 104 °F). Standard Humidity: 20-80%. Battery: Rechargeable Lithium-Ion 550 mAh battery. Charging Time: 3-4 Hours. Package Weight: 0.386Kg (0.851 Lb). Product Dimensions (L X W X H): 15.30X11.10X6.10 Cm (6.02X4.37X2.4 In). Package Dimensions (L X W X H): 18.00X16.00X7.00 Cm (7.09X6.3X2.76 In).",0,(float) 5.0);
        db.insertProduct(p15,ShoppingDatabase.TB_GAME);

        // Car tool
        Products p16 = new Products(R.drawable.car_tool2,"Tire opening crank for truck HT-68C",48.33,"Power crank",24,"This is a specialized hand crank tool to remove/tighten truck wheel screws, a short manual truck tire screw opener set that is flexible, convenient to carry, and convenient for replacing and repairing any vehicle anytime, anywhere. Short manual screw opener made from impact-resistant and abrasion-resistant steel. The details are precisely machined, the threads fit tightly, and do not come loose during use. The handle is covered with black plastic and has a rough texture to help prevent slipping when operating. Specialized tire screw removal tool set for power cranks for non-electric trucks, screwed by specialized hands, simple, safe without wasting effort. 2 sockets 32mm and 33mm suitable for trucks and pickups. The manual tire screw opener is constructed and operates with many internal gears, making it easier to remove tire screws.",0,(float) 4.0);
        db.insertProduct(p16,ShoppingDatabase.TB_CAR_TOOL);

        Products p17 = new Products(R.drawable.car_tool1,"High quality car steering wheel cover SJT0102",24.03,"SJT0102",34,"Design helps achieve high performance, good grip, with a principle based on increasing the contact area with your hands, helping you control the steering wheel more easily. The steering wheel cover is perforated with tiny holes in the leather to help breathe and wick away sweat. Material: PU leather and felt fabric, durable and beautiful, absorbs sweat well. High quality materials and manufactured from technology and highly skilled workers. Steering wheel cover includes high-quality genuine leather on the outside and high-quality natural rubber on the inside. This premium black leather steering wheel cover measures 38 cm and fits most 5-seat and 7-seat cars.",0,(float) 4.0);
        db.insertProduct(p17,ShoppingDatabase.TB_CAR_TOOL);

        // Beauty tool
        Products p18 = new Products(R.drawable.beauty_tool1,"Eye Makeup Brush Mac 252s Large Shader Brush",20.03,"Makeup brushes",20,"Mac Eye Makeup Brush 252s Large Shader Brush is an eye brush product from the famous cosmetic brand M.A.C Cosmetics with a large, wide brush head design, sturdy bristles suitable for applying base, primer or powder all over the eye. In particular, the brush is very useful for cut crease eyeshadow.",0,(float) 4.0);
        db.insertProduct(p18,ShoppingDatabase.TB_BEAUTY);

        Products p19 = new Products(R.drawable.beauty_tool2,"Horus Coffee Make Up Sponge",2.03,"Makeup brushes",34,"Horus Coffee Make Up Sponge is a makeup sponge product from the Chinese makeup brand Horus, inspired by coffee with a soft, spongy, highly elastic cotton material that helps spread the foundation layer evenly. It covers the face and optimally covers blemishes and creates the perfect foundation for a radiant, smooth face, perfect for subsequent makeup layers. Classify: Latte (Gray): Water Drop Shape. Espresso (Black): Fox Shape. Mocha (Brown): Diagonal shape.",0,(float) 4.0);
        db.insertProduct(p19,ShoppingDatabase.TB_BEAUTY);

        // Book
        Products p20 = new Products(R.drawable.book1,"Sobotta – Atlas of Human Anatomy",49.33,"Atlas of Human Anatomy",8,"The book has a new didactic perspective: Accurate, clear, integrating clinical medicine, suitable for all study programs. Complete gross anatomy: Atlas Sobotta presents complete gross anatomy content with nearly 2,000 detailed and high-quality images. Easy to use: Programs are arranged according to body areas. Overview diagrams and outlines at the beginning of the book help readers gradually understand more complex shapes and their relationships.",0,(float) 5.0);
        db.insertProduct(p20,ShoppingDatabase.TB_BOOK);

        Products p21 = new Products(R.drawable.book2,"English Grammar Explanation – Mai Lan Huong (2023 version)",12.33,"English book",10,"The book English Grammar Explanation 2023 by author Mai Lan Huong includes 9 chapters, the book's content is presented according to English grammar topics from basic to advanced, suitable for all levels. The grammar topics in the chapter are compiled in detail, thoroughly explaining the usage and rules that learners need to master. After each topic of English Grammar Explanation by Mai Lan Huong, there are diverse exercises to help learners consolidate the theory.",0,(float) 5.0);
        db.insertProduct(p21,ShoppingDatabase.TB_BOOK);

        // Sports
        Products p22 = new Products(R.drawable.sport1,"Adidas Adizero Sl Men's Running Shoes",122.10,"Adidas",30,"The adidas ADIZERO SL is a speedy everyday trainer, equipped with key components and design highlights from the world record-breaking Adizero shoe line. The midsole has a full EVA midsole using ultra-light Lightstrike technology, creating a balance between stability, flexibility and comfort. Along with that, the world-famous Lightstrike Pro foam and the speed training shoe body made from super soft technical mesh fabric are arranged in important positions. The heel structure and padded tongue help enhance comfort when putting on and striding, combined with the flashing ADIZERO logo on the heel to create a highlight on the shoe body. Finally, the all-rubber outsole grips well on any surface – in all weather conditions. Made from a range of recycled materials, the shoe upper contains a minimum of 50% recycled content. This product represents one of many adidas solutions aimed at ending plastic waste.",0,(float) 4.5);
        db.insertProduct(p22,ShoppingDatabase.TB_SPORTS);

        Products p23 = new Products(R.drawable.sport2,"Under Armor Hovr™ Machina 2 Se Women's Sneakers",178.88,"Under Armour",20,"Determined to speed up after each run. A mesh upper and soft rubber cushioning give the Under Armor HOVR™ Machina 2 SE a technical look and a comfortable, supportive fit. When you're ready to go fast, the ultra-lightweight Pebax® thrust plates are ready to help.",0,(float) 5.0);
        db.insertProduct(p23,ShoppingDatabase.TB_SPORTS);

//        Products p = new Products(15);
//        db.deleteProduct(p,ShoppingDatabase.TB_FASHION);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQ_COD);
        }



        rv = findViewById(R.id.rv_home);
        shp = getSharedPreferences("myPreferences", MODE_PRIVATE);
        shp_id = getSharedPreferences("Preferences_id", MODE_PRIVATE);

        ArrayList<Products> products1 = new ArrayList<>();
        products1 = db.getAllProducts(ShoppingDatabase.TB_PRODUCT_DISCOUNT);
        HomeAdabter adapter = new HomeAdabter(products1, new OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(int productId) {
                Intent i = new Intent(getBaseContext(),DisplayProductsActivity.class);
                i.putExtra(PRODUCT_KEY,productId);
                i.putExtra(TABLE_NAME_KEY,ShoppingDatabase.TB_PRODUCT_DISCOUNT);
                flag = true;
                startActivity(i);
            }
        });
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rv.setLayoutManager(lm);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);

        bnv = findViewById(R.id.BottomNavigationView);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent1 = new Intent(getBaseContext(),HomeActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.products:
                        Intent intent2 = new Intent(getBaseContext(),MainActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.profile:
                        Intent intent3 = new Intent(getBaseContext(),ProfileActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.basket:
                        Intent intent4 = new Intent(getBaseContext(),PurchasesActivity.class);
                        startActivity(intent4);
                        break;
                    case R.id.contact:
                        Intent intent5 = new Intent(getBaseContext(), ContactActivity.class);
                        startActivity(intent5);
                        break;
                }

                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_up_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                logout();
                break;
            case R.id.settings:
                Intent intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        try {
            if (shp == null){
                shp = getSharedPreferences("myPreferences", MODE_PRIVATE);
            }
            shpEditor = shp.edit();
            shpEditor.putInt("user", 0);
            shpEditor.commit();

            if (shp_id == null){
                shp_id = getSharedPreferences("Preferences_id", MODE_PRIVATE);
            }
            shpEditor_id = shp_id.edit();
            shpEditor_id.putInt("user_id",0);
            shpEditor_id.commit();

            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            finish();

        }catch (Exception ex){
            Toast.makeText(this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_REQ_COD:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                }else{

                }
        }
    }

}