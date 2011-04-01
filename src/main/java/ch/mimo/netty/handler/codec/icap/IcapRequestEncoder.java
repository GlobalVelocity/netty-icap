/*******************************************************************************
 * Copyright (c) 2011 Michael Mimo Moratti.
 *  
 * Michael Mimo Moratti licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package ch.mimo.netty.handler.codec.icap;

import org.jboss.netty.buffer.ChannelBuffer;

public class IcapRequestEncoder extends IcapMessageEncoder {

	public IcapRequestEncoder() {
		super();
	}
	
	@Override
	protected int encodeInitialLine(ChannelBuffer buffer, IcapMessage message) throws Exception {
		IcapMessage request = (IcapMessage) message;
		// TODO replace ASCII literal
		int index = buffer.readableBytes();
        buffer.writeBytes(request.getMethod().toString().getBytes("ASCII"));
        buffer.writeByte(IcapCodecUtil.SP);
        buffer.writeBytes(request.getUri().getBytes("ASCII"));
        buffer.writeByte(IcapCodecUtil.SP);
        buffer.writeBytes(request.getProtocolVersion().toString().getBytes("ASCII"));
        buffer.writeByte(IcapCodecUtil.CR);
        buffer.writeByte(IcapCodecUtil.LF);
        return buffer.readableBytes() - index;
	}

}