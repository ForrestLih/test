package apiitools;

import java.io.File;
import java.io.IOException;
/**
 * ������һ��File��Ĺ����࣬�����˴����ļ���ɾ���ļ���Ŀ¼������Ŀ¼�������ļ�/Ŀ¼�ܴ�С�ȷ�����
 * @author Administrator
 *
 */
public class FileItools {

	/**
	 * �����ļ�������ļ��������򣬴����ļ������Ѿ����ڣ�����ʾ���ļ��Ѵ��ڡ�
	 * @param file
	 * @throws IOException
	 */
	public static void creatFile(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
			System.out.println(file.getAbsolutePath() + " " + "�ļ������ɹ���");
		} else {
			System.out.println(file.getAbsolutePath() + " " + "(�ļ��Ѵ��ڣ�)");
		}
	}
	/**
	 * ɾ���ļ���Ŀ¼:������ļ���ֱ��ɾ��������Ŀ¼��ɾ��Ŀ¼(�ǿ�Ŀ¼Ҳ��ɾ��)���������ڣ���ʾ�ļ�/Ŀ¼�����ڡ�
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
			System.out.println(file.getAbsolutePath() + " " + "��ɾ��");
		} else {
			System.out.println(file.getAbsolutePath() + " " + "(�ļ�/Ŀ¼������)");
		}
	}
	/**
	 * ����Ŀ¼����Ŀ¼�Ѵ��ڣ���ʾĿ¼���ڡ���Ŀ¼�������򴴽�Ŀ¼������ָ�����Ŀ¼������
	 * @param file
	 */
	public static void creatDirs(File file) {
		if (!file.exists()) {
			file.mkdirs();
			System.out.println(file.getAbsolutePath() + " " + "Ŀ¼�����ɹ���");
		} else {
			System.out.println(file.getAbsolutePath() + " " + "(Ŀ¼�Ѵ��ڣ�)");
		}
	}
	
	static long lengthSum = 0;
	/**
	 * �����ļ�/Ŀ¼�ܴ�С����λ�ֽڡ�
	 * @param file
	 * @return lengthSum ��Ϊ�����һ����̬��������ͼ���ڼ�¼�ļ���С��
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
