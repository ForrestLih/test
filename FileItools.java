package apiitools;

import java.io.File;
import java.io.IOException;
/**
 * 该类是一个File类的工具类，包含了创建文件，删除文件或目录，创建目录，计算文件/目录总大小等方法。
 * @author Administrator
 *
 */
public class FileItools {

	/**
	 * 创建文件：如果文件不存在则，创建文件；若已经存在，则提示：文件已存在。
	 * @param file
	 * @throws IOException
	 */
	public static void creatFile(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
			System.out.println(file.getAbsolutePath() + " " + "文件创建成功！");
		} else {
			System.out.println(file.getAbsolutePath() + " " + "(文件已存在！)");
		}
	}
	/**
	 * 删除文件或目录:如果是文件则直接删除，若是目录则删除目录(非空目录也能删除)，若不存在，提示文件/目录不存在。
	 * @param file
	 */
	public static void deleteFile(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] fileList = file.listFiles();
				for (int i = 0; i < fileList.length; i++) {
					deleteFile(fileList[i]);
				}
			}
			file.delete();
			System.out.println(file.getAbsolutePath() + " " + "已删除");
		} else {
			System.out.println(file.getAbsolutePath() + " " + "(文件/目录不存在)");
		}
	}
	/**
	 * 创建目录：若目录已存在，提示目录存在。若目录不存在则创建目录，可以指定多层目录创建。
	 * @param file
	 */
	public static void creatDirs(File file) {
		if (!file.exists()) {
			file.mkdirs();
			System.out.println(file.getAbsolutePath() + " " + "目录创建成功！");
		} else {
			System.out.println(file.getAbsolutePath() + " " + "(目录已存在！)");
		}
	}
	
	static long lengthSum = 0;
	/**
	 * 计算文件/目录总大小：单位字节。
	 * @param file
	 * @return lengthSum 作为该类的一个静态变量，意图在于记录文件大小。
	 */
	public static long printFileLength(File file) {
		if (file.isDirectory()) {
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				if(fileList[i].isDirectory()){
					printFileLength(fileList[i]);
				}else{
					lengthSum+=fileList[i].length();
				}
			}
		}else{
			lengthSum+=file.length();
		}
		
		return lengthSum;
	}
//	public static File[] fileFileter(File file,String limits){
//		File[] fileListFF = null;
//		FileFilter ff = new FileFilter(){
//			@Override
//			public boolean accept(File file1) {
//				return 	file1.getName().startsWith(limits);
//			}
//			
//		};
//		fileListFF = file.listFiles(ff);
//		return fileListFF;
//	}
	
}
