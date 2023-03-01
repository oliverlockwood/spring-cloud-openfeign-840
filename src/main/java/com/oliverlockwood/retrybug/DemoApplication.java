package com.oliverlockwood.retrybug;

import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;


@SpringBootApplication
@EnableFeignClients(basePackages = { "com.oliverlockwood.retrybug" })
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

		log.info("Started application OK; programming Wiremock");

		WireMock downstreamService1 = new WireMock("127.0.0.1", 18000);
		downstreamService1.register(
				get(urlEqualTo("/api/something"))
						.willReturn(ok()
								.withFixedDelay(2000)
								.withHeader("Content-Type", "application/json")
								.withBody("hello - sorry for being late!")));

		WireMock downstreamService2 = new WireMock("127.0.0.1", 18001);
		downstreamService2.register(
				get(urlEqualTo("/api/something"))
						.willReturn(ok()
								.withFixedDelay(2000)
								.withHeader("Content-Type", "application/json")
								.withBody("hello - I'm right on time!")));
	}

}
