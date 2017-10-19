package org.ethereum.rpc;

import co.rsk.rpc.JsonRpcFilterServer;
import co.rsk.rpc.ModuleDescription;
import co.rsk.rpc.OriginValidator;
import com.googlecode.jsonrpc4j.AnnotationsErrorResolver;
import com.googlecode.jsonrpc4j.DefaultErrorResolver;
import com.googlecode.jsonrpc4j.MultipleErrorResolver;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import org.ethereum.rpc.exception.RskErrorResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by ajlopez on 18/10/2017.
 */

@ChannelHandler.Sharable
public abstract class JsonRpcWeb3FilterHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private static final Logger LOGGER = LoggerFactory.getLogger("jsonrpc");

    private OriginValidator originValidator;

    public JsonRpcWeb3FilterHandler(String corsOrigins) {
        try {
            this.originValidator = new OriginValidator(corsOrigins);
        } catch (URISyntaxException e) {
            LOGGER.error("Error creating OriginValidator, origins {}", corsOrigins);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        super.channelRead(ctx, msg);
    }
}
