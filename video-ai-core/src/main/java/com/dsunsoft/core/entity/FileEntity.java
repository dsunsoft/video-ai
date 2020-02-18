package com.dsunsoft.core.entity;

/**
 * @author zb
 * 文件实体类
 */
public class FileEntity {

    /**
     * 文件后缀
     */
    private  String fileType;
    /**
     * 文件相对路径
     */
    private  String relativeUrl;
    /**
     * 文件绝对路径
     */
    private  String filePath;
    /**
     * 获取 fileType
     * @return fileType fileType
     */
    public String getFileType() {
        return fileType;
    }
    
    /**
     * 设置 fileType
     * @param fileType fileType 
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    /**
     * 获取 filePath
     * @return filePath filePath
     */
    public String getFilePath() {
        return filePath;
    }
    
    /**
     * 设置 filePath
     * @param filePath filePath 
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 获取 relativeUrl
     * @return relativeUrl relativeUrl
     */
    public String getRelativeUrl() {
        return relativeUrl;
    }

    /**
     * 设置 relativeUrl
     * @param relativeUrl relativeUrl 
     */
    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }

   
   
}
