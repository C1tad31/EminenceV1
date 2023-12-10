module Eminence.main {
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.driver.core;
    requires de.mkammerer.argon2.nolibs;
    requires lombok;
    requires com.sun.jna;
    requires org.mongodb.bson;
    requires MaterialFX;

    opens me.c1tad31.eminence to javafx.graphics, javafx.base, javafx.controls, javafx.fxml;
    opens me.c1tad31.eminence.admin to javafx.graphics, javafx.base, javafx.controls, javafx.fxml;
    opens me.c1tad31.eminence.login to javafx.graphics, javafx.base, javafx.controls, javafx.fxml;
//    opens me.c1tad31.eminence.register to javafx.graphics, javafx.base, javafx.controls, javafx.fxml;
    opens me.c1tad31.eminence.dashboard to javafx.graphics, javafx.base, javafx.controls, javafx.fxml;
    opens me.c1tad31.eminence.settings to javafx.graphics, javafx.base, javafx.controls, javafx.fxml;
    opens me.c1tad31.eminence.stresshub to javafx.graphics, javafx.base, javafx.controls, javafx.fxml;
    opens me.c1tad31.eminence.tools to javafx.graphics, javafx.base, javafx.controls, javafx.fxml;

    exports me.c1tad31.eminence;
    exports me.c1tad31.eminence.admin;
    exports me.c1tad31.eminence.login;
//    exports me.c1tad31.eminence.register;
    exports me.c1tad31.eminence.utils;
    exports me.c1tad31.eminence.dashboard;
    exports me.c1tad31.eminence.settings;
    exports me.c1tad31.eminence.stresshub;
    exports me.c1tad31.eminence.tools;

}