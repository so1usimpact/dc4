package backend.service;

import backend.websockets.TransactionListener.WebSocketTransaction;
import bowser.websocket.ClientSocket;
import ox.Json;

public class ConnectionService {

  private static final ConnectionService instance = new ConnectionService();

  private static final int VERIFY_CONNECTION_TIMEOUT = 2000; // 2 seconds to verify connection.

  public static ConnectionService get() {
    return instance;
  }

  public boolean verifyConnection(ClientSocket socket) {
    return new WebSocketTransaction<Boolean>(socket)
        .message(Json.object()
            .with("channel", "connection")
            .with("command", "verify")
            .with("data", Json.object())) // no data,.
        .setTimeoutMillis(VERIFY_CONNECTION_TIMEOUT)
        .onFail(() -> false)
        .onResponse(anyResponse -> true)
        .execute()
        .getResult();
  }

}
