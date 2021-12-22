package com.perfios.service;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class VfsUtilityServiceImpl implements VfsUtilityService {
    @Override
    public boolean Copy(String source, String target) {
        FileSystemManager fsManager = null;
        try {
            fsManager = VFS.getManager();

            FileSystemOptions opts = new FileSystemOptions();
            SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(
                    opts, "no");
            SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
            SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

            FileObject fileToCopy = fsManager.resolveFile(source);

            FileObject destinationDirectory = fsManager.resolveFile(target,opts);
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

    @Override
    public void delete(String sourceUri) {

        FileSystemManager fsManager = null;
        try {
            fsManager = VFS.getManager();
            FileObject destinationDirectory = fsManager.resolveFile(sourceUri);
            destinationDirectory.delete();
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }
}
