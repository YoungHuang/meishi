package meishi

class ResponseMessage {
  final static int FAILED = 1000
  final static int NETWORK_ERROR = 1001
  
  int errorCode
  String errorMessage
}
