security-manager
===========================

ExecPreventionSecurityManager prevents calls to {@link Runtime#exec(String cmd)}. Whilst maintainers should try their best to upgrade vulnerable third party libraries as soon as a new release is available it is not always possible. {@link Runtime#exec(String cmd)} is a common entry point for remote code execution backdoors. If you run a web application which does not rely on the exec call configuring your JVM with this security manager will provide an extra layer of protection.

## Apache Tomcat 7.x

Copy security-manager.jar and setenv.sh to CATALINA bin directory.

```sh
export CLASSPATH=$CATALINA_BASE/bin/security-manager.jar
export JAVA_OPTS=-Djava.security.manager=ExecPreventionSecurityManager
```
