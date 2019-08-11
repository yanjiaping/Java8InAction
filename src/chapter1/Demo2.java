package chapter1;

import java.io.File;
import java.io.FileFilter;

public class Demo2 {

	public static void main(String[] args) {
		/*File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isHidden();
			}
		});*/

		/**
		 * 方法引用
		 */
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);
	}

}
