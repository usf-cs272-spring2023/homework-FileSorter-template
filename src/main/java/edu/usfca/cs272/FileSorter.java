package edu.usfca.cs272;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;

/**
 * A simple class for sorting files.
 *
 * @author CS 272 Software Development (University of San Francisco)
 * @version Fall 2022
 */
public class FileSorter {
	/**
	 * A simple comparable class for storing and comparing files. Should implement
	 * the {@link Comparable} interface to allow for comparison between
	 * {@link FileMetadata} objects by their {@link FileMetadata#path} paths.
	 *
	 * @see Comparable
	 * @see Path#compareTo(Path)
	 * @see FileMetadata#path
	 */
	// TODO Update declaration to implement Comparable interface
	public static class FileMetadata /* TODO Update declaration here */ {
		/** The normalized file path. */
		private final Path path;

		/** The file name. */
		private final String name;

		/** The file size. */
		private final long size;

		/** The last modified date of the file. */
		private final FileTime date;

		/**
		 * Initializes a file and its metadata.
		 *
		 * @param path the text file source
		 * @throws IOException if I/O error occurs
		 */
		public FileMetadata(Path path) throws IOException {
			this.path = path.normalize();
			this.name = path.getFileName().toString();
			this.size = Files.isRegularFile(path) ? Files.size(path) : -1;
			this.date = Files.isRegularFile(path) ? Files.getLastModifiedTime(path) : FileTime.fromMillis(0);
		}

		@Override
		public String toString() {
			String output = this.path.getNameCount() < 1 ? this.name : path.toString();
			return String.format("%s (%s bytes, modified %s)", output, size, date);
		}

		/**
		 * Compares {@link FileMetadata} objects by their {@link Path} source.
		 *
		 * @param other the other object to compare against
		 * @return a negative integer, zero, or a positive integer as the first
		 *   argument is less than, equal to, or greater than the second.
		 *
		 * @see Path#compareTo(Path)
		 * @see Comparable#compareTo(Object)
		 */
		public int compareTo(FileMetadata other) {
			// TODO Implement compareTo(...) to compare by path
			throw new UnsupportedOperationException("Not yet implemented");
		}
	}

	// TODO Add members, inner and static nested classes, and methods as needed.
	// TODO Replace null values with actual Comparator instances!

	/**
	 * A comparator that compares files by their last modified date, defined
	 * using a static nested class.
	 *
	 * @see FileMetadata#date
	 * @see FileTime#compareTo(FileTime)
	 */
	// TODO Create a STATIC NESTED CLASS and use it for the comparator below
	public static final Comparator<FileMetadata> DATE_COMPARATOR = null;

	/**
	 * A comparator that compares text files in case insensitive order by their
	 * name, defined using a non-static inner class.
	 *
	 * @see FileMetadata#name
	 * @see String#CASE_INSENSITIVE_ORDER
	 */
	// TODO Create an INNER CLASS and use it for the comparator below
	public static final Comparator<FileMetadata> NAME_COMPARATOR = null;

	/**
	 * A comparator that compares text files by their size with the largest sizes
	 * first (descending order), defined using a lambda expression.
	 *
	 * @see FileMetadata#size
	 * @see Long#compare(long, long)
	 */
	// TODO Create a LAMBDA EXPRESSION and use it for the comparator below
	public static final Comparator<FileMetadata> SIZE_COMPARATOR = null;

	/**
	 * Returns a comparator created using an anonymous inner class that compares
	 * text files by the {@link #SIZE_COMPARATOR} if the sizes are not equal. If
	 * the sizes are equal, then compares using a {@link #NAME_COMPARATOR}
	 * instead. If the names are equal, then compares by the {@link FileMetadata}
	 * natural sort order (by its {@link Path} source).
	 *
	 * @see #SIZE_COMPARATOR
	 * @see #NAME_COMPARATOR
	 * @see FileMetadata#compareTo(FileMetadata)
	 *
	 * @return a comparator created using an anonymous inner class
	 */
	public static Comparator<FileMetadata> getNested() {
		// TODO Implement getNested() using an anonymous inner class
		return null;
	};

}
