import com.momo.grpc.User;
import com.momo.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class grpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090)
                .usePlaintext().build();

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("tu")
                .setPassword("tu").build();
        userStub.login(loginRequest);

        User.APIResponse response = userStub.login(loginRequest);

        System.out.println(response.getResponseMessage());
    }
}
