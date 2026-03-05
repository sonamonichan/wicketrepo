package com.arun;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

/**
 * Separate startup class for people that want to run the examples directly. Use parameter
 * -Dcom.sun.management.jmxremote to startup JMX (and e.g. connect with jconsole).
 *
 * NOTE: This class previously used embedded Jetty 9 for local development.
 * The application now targets Tomcat 10.1 (Jakarta Servlet) deployment.
 * Embedded Jetty 9 is incompatible with Jakarta EE and Java 21.
 * Deploy the WAR file to Tomcat 10.1+ instead.
 */
public class Start
{
	/**
	 * Main function, previously started the embedded Jetty server.
	 * Now prints deployment instructions for Tomcat 10.1.
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("=================================================================");
		System.out.println("This application now targets Tomcat 10.1+ (Jakarta Servlet 6.0).");
		System.out.println("The embedded Jetty 9 launcher has been removed as it is");
		System.out.println("incompatible with Jakarta EE and Java 21.");
		System.out.println("");
		System.out.println("To run this application:");
		System.out.println("  1. Build: mvn clean package");
		System.out.println("  2. Deploy target/addressbook.war to Tomcat 10.1+");
		System.out.println("  3. Access: http://localhost:8080/addressbook");
		System.out.println("=================================================================");

		// MBeanServer reference kept for JMX monitoring capability
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		System.out.println("JMX MBeanServer available: " + (mBeanServer != null));
	}
}
