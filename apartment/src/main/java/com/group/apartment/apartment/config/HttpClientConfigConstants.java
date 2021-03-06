package com.group.apartment.apartment.config;

public class HttpClientConfigConstants {

    // Connection pool
    public static int MAX_ROUTE_CONNECTIONS = 40;
    public static int MAX_TOTAL_CONNECTIONS = 40;
  public static  int MAX_LOCALHOST_CONNECTIONS = 80;

    // Keep alive
   public static  int DEFAULT_KEEP_ALIVE_TIME = 20 * 1000; // 20 sec

    // Timeouts
   public static int CONNECTION_TIMEOUT = 30 * 1000; // 30 sec, the time for waiting until a connection is established
   public static int REQUEST_TIMEOUT = 30 * 1000; // 30 sec, the time for waiting for a connection from connection pool
   public static int SOCKET_TIMEOUT = 60 * 1000; // 60 sec, the time for waiting for data

    // Idle connection monitor
   public static int IDLE_CONNECTION_WAIT_TIME = 30 * 1000; // 30 sec
}