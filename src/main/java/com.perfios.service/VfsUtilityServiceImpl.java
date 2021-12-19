package com.perfios.service;

import org.apache.commons.vfs2.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class VfsUtilityServiceImpl implements VfsUtilityService {
    @Override
    public boolean Copy(String source, String target) {
        FileSystemManager fsManager = null;
        try {
            fsManager = VFS.getManager();
            FileObject fileToCopy = fsManager.resolveFile("C:\\Users\\DELL\\Desktop\\spring-application\\vfs-utility\\LocalSource\\file1.text");


            FileObject destinationDirectory = fsManager.resolveFile("C:\\Users\\DELL\\Desktop\\spring-application\\vfs-utility\\LocalTarget");
            FileFilter nameFileFilter = new FileFilter() {
                @Override
                public boolean accept(FileSelectInfo fileSelectInfo) {
                   // (Arrays.asList("2004220.csv")
                    return true;
                }
            };
            FileSelector fileSelector = new FileFilterSelector(nameFileFilter);
            destinationDirectory.copyFrom(fileToCopy,fileSelector);

            //jarFiles.copyFrom(fileToCopy);
            //System.out.println(jarFiles.getName().getBaseName());
        } catch (FileSystemException e) {
            e.printStackTrace();
        }

        System.out.println("This is service test.");
        return false;
    }
}
