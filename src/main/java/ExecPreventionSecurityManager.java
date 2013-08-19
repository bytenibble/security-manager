import java.io.FileDescriptor;
import java.lang.SecurityManager;
import java.net.InetAddress;
import java.security.Permission;
import java.security.Security;

/**
 * Prevents calls to {@link Runtime#exec(String cmd)}.
 *
 * @author Johno Crawford (johno@bytenibble.com)
 */
public class ExecPreventionSecurityManager extends SecurityManager {

    private static final RuntimePermission permissionToSetSecurityManager = new RuntimePermission("setSecurityManager");

    /**
     * JVM behavior is to cache forever when a security manager is installed, set default values for TCP load-balancing support.
     * Must be set before first TCP connection!
     */
    static {
        Security.setProperty("networkaddress.cache.ttl", "60");
        Security.setProperty("networkaddress.cache.negative.ttl", "10");
    }

    @Override
    public void checkPermission(Permission perm) {
        if (permissionToSetSecurityManager.equals(perm)) {
            throw new SecurityException("Attempted to set security manager");
        }
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        if (permissionToSetSecurityManager.equals(perm)) {
            throw new SecurityException("Attempted to set security manager");
        }
    }

    @Override
    public void checkCreateClassLoader() {
    }

    @Override
    public void checkAccess(Thread t) {
    }

    @Override
    public void checkAccess(ThreadGroup g) {
    }

    @Override
    public void checkExit(int status) {
    }

    @Override
    public void checkExec(String cmd) {
        throw new SecurityException(String.format("Attempted to execute '%s'", cmd));
    }

    @Override
    public void checkLink(String lib) {
    }

    @Override
    public void checkRead(FileDescriptor fd) {
    }

    @Override
    public void checkRead(String file) {
    }

    @Override
    public void checkRead(String file, Object context) {
    }

    @Override
    public void checkWrite(FileDescriptor fd) {
    }

    @Override
    public void checkWrite(String file) {
    }

    @Override
    public void checkDelete(String file) {
    }

    @Override
    public void checkConnect(String host, int port) {
    }

    @Override
    public void checkConnect(String host, int port, Object context) {
    }

    @Override
    public void checkListen(int port) {
    }

    @Override
    public void checkAccept(String host, int port) {
    }

    @Override
    public void checkMulticast(InetAddress maddr) {
    }

    @SuppressWarnings({"deprecation"})
    @Override
    public void checkMulticast(InetAddress maddr, byte ttl) {
    }

    @Override
    public void checkPropertiesAccess() {
    }

    @Override
    public void checkPropertyAccess(String key) {
    }

    @Override
    public boolean checkTopLevelWindow(Object window) {
        return true;
    }

    @Override
    public void checkPrintJobAccess() {
    }

    @Override
    public void checkSystemClipboardAccess() {
    }

    @Override
    public void checkAwtEventQueueAccess() {
    }

    @Override
    public void checkPackageAccess(String pkg) {
    }

    @Override
    public void checkPackageDefinition(String pkg) {
    }

    @Override
    public void checkSetFactory() {
    }

    @Override
    public void checkMemberAccess(Class<?> clazz, int which) {
    }

    @Override
    public void checkSecurityAccess(String target) {
    }
}
