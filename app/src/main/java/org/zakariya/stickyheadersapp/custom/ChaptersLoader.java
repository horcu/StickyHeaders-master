package org.zakariya.stickyheadersapp.custom;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;

import org.zakariya.stickyheadersapp.api.AssetGetter;

import java.io.File;

/**
 * Created by Horatio on 6/26/2016.
 */

public class ChaptersLoader {


    private static void uploadJsonToFirebase(String json) {

    }

    public static String CombineAssetsIntoOneJsonFile(Context ctx, String topLevelFolderName){

        String[] allFolders = AssetGetter.getSectionNames(ctx,topLevelFolderName );

        for(int i=0; i < allFolders.length; i++){
            String path = topLevelFolderName + File.separator + allFolders[i];

            String[] subNames = AssetGetter.getSectionNames(ctx, path);
            boolean hasSubFolders = subNames !=null;


            //operations

            // use folder name to check for json file
                       // if file found then call method to return the lesson from that json
                              //then save that lesson under that folder name
            // if file not found then grab the name and attach it to the former toplevelfolder and repeat search






            if(hasSubFolders){

                //then recursively dig in
            }
            else { //then we have reached paydirt - the json files. now we process and back our way out

            }

        }
        return topLevelFolderName;
    }
}

