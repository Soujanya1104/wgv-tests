package com.onpier.wgv.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties configProps;
    static Properties phraseProps;
    public static Properties getConfigProps(){
        return configProps;
    }

    public static Properties getPhraseProps(){
        return phraseProps;
    }
    public static void loadProps() throws IOException {
        String baseProjectPath=System.getProperty("user.dir");
        configProps=new Properties();
        configProps.load(new FileReader(new File(baseProjectPath.concat("/src/main/resources/config/env.properties"))));
        phraseProps=new Properties();
        phraseProps.load(new FileReader(new File(baseProjectPath.concat("/src/main/resources/config/phrase.properties"))));
    }
}
