

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

public class BaseArquillianTest {

	// private static final String WEBAPP_SRC = "src/main/webapp";
	//
	// @Deployment
	// public static WebArchive createDeployment() {
	//
	// return ShrinkWrap
	// .create(WebArchive.class, "test.war")
	// // get high level package and all below it
	// .addPackages(true, "packagename")
	// .addAsResource("META-INF/persistence.xml",
	// "META-INF/persistence.xml")
	// .addAsWebInfResource(
	// new File(WEBAPP_SRC + "/WEB-INF", "beans.xml"))
	// .addAsWebInfResource(EmptyAsset.INSTANCE, "faces-config.xml");
	// }
	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar =
				ShrinkWrap
						.create(JavaArchive.class, "test.jar")
						.addPackages(true, "package")
						.addPackages(true, "package")
						.addAsResource(new File("src/main/java/pathtofile", "filename"),
								"pathtofile/filename")
						.addAsManifestResource(
								new File("src/main/resources/META-INF", "persistence.xml"))
						.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
						.addAsResource(new File("src/test/resources", "users.properties"))
						.addAsResource(new File("src/test/resources", "roles.properties"));
		System.out.println(jar.toString(true));
		return jar;
	}
}
