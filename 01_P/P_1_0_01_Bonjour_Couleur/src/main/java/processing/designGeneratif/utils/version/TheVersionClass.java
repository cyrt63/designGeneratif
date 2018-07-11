/*
 * https://blog.soebes.de/blog/2014/01/02/version-information-into-your-appas-with-maven/
 * https://github.com/khmarbaise/version-examples/tree/master/version-example-iii
 */

package processing.designGeneratif.utils.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TheVersionClass {

	private Properties prop;
	private String Version;
	private String GroupId;
	private String ArtifactId;
	private String Path;
	
	public String getVersion() {
		return Version;
	}

	public String getGroupId() {
		return GroupId;
	}

	public String getArtifactId() {
		return ArtifactId;
	}

	public String getPath() {
		return Path;
	}

	private String getEntryById(String id) {
		return prop.getProperty(id);
	}

	public TheVersionClass() {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("/version.properties");
		this.prop = new Properties();
		try {
			this.prop.load(resourceAsStream);
		} catch (IOException e) {
			// FIXME: This should be done by using a logging framework like log4j etc.
			e.printStackTrace();
		}

		this.Version = getEntryById("version");
		this.GroupId = getEntryById("groupId");
		this.ArtifactId = getEntryById("artifactId");
		this.Path = this.GroupId + "." + this.ArtifactId;

		System.out.println("Version: " + this.Version);
		System.out.println("groupId: " + this.GroupId);
		System.out.println("artifactId: " + this.ArtifactId);
		System.out.println("Path: " + this.Path);
	}
}
