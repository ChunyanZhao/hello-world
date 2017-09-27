import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//File类的基本用法
class FileTest{
	public static void main(String[] args) throws IOException{
		Logger logger = LoggerFactory.getLogger(FileTest.class);
		logger.info("hello {}",new Date());
		//构造函数
		File file = new File("/Users/aliyun/Desktop/截图");
		System.out.println("This file "+"/Users/aliyun/Desktop/截图"+"exists?:"+file.exists());
		if(!file.exists()){
			file.mkdir(); //file.mkdirs() 生成多级目录
		}else{
		//	file.delete();
		}
		//判断是否是一个目录
		System.out.println("This is a directory?:"+file.isDirectory());
		//判断是否是一个文件
		System.out.println("This is a file?:"+file.isFile());

		File file2 = new File("/home/yangz/yangz.pub");
		System.out.println(file);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		FileTest.listDirectory(new File("/Users/aliyun/Desktop/截图"));

		//系统属性类Properties类
		java.util.Properties properties = System.getProperties();
		properties.list(System.out);
	}
	//列出指定目录（包括其子目录）下所有文件
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("Directory:"+dir+" doesn`t exists!");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+" is now a directory!");
		}
		//System.out.println(dir.list());
		String[] filenames = dir.list();
		for(String string:filenames){
			System.out.println(dir+"/"+string);
		}
		//返回直接子目录的File对象
		File[] files = dir.listFiles();
		if(files!=null && files.length>0){
		for(File file:files){
				if(file.isDirectory()){
					//递归操作
					System.out.println(file.getName()+"-");
					listDirectory(file);
				}else{
					System.out.println(file.getName());
				}
			}
		}

	}
}