package io.github.asewhy.net.support;

public class RouteFlags {
    public static final long NONE       = 0x0;
    public static final long UP         = 0x1;
    public static final long GATEWAY    = 0x2;
    public static final long HOST       = 0x4;
    public static final long REINSTATE  = 0x8;
    public static final long DYNAMIC    = 0x10;
    public static final long MODIFIED   = 0x20;
    public static final long MTU        = 0x40;
    public static final long MSS        = 0x80;
    public static final long WINDOW     = 0x100;
    public static final long IRTT       = 0x200;
    public static final long REJECT     = 0x400;
    public static final long STATIC     = 0x800;
    public static final long XRESOLVE   = 0x1000;
    public static final long NOFORWARD  = 0x2000;
    public static final long THROW      = 0x4000;
    public static final long NOPMTUDISC = 0x8000;
}
