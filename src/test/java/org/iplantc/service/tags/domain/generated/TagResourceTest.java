package org.iplantc.service.tags.domain.generated;

import org.minnal.core.serializer.Serializer;
import org.minnal.core.resource.BaseJPAResourceTest;
import org.testng.annotations.Test;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.minnal.core.Response;
import static org.testng.Assert.*;

/**
 * This is an auto generated test class by minnal-generator
 */
public class TagResourceTest extends BaseJPAResourceTest {
	@Test
	public void listTagTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();
		Response response = call(request("/tags/", HttpMethod.GET));
		assertEquals(response.getStatus(), HttpResponseStatus.OK);
		assertEquals(serializer.deserializeCollection(
				response.getContent(), java.util.List.class,
				org.iplantc.service.tags.domain.Tag.class)
				.size(),
				(int) org.iplantc.service.tags.domain.Tag
						.count());
	}

	@Test
	public void readTagTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();
		Response response = call(request("/tags/" + tag.getId(),
				HttpMethod.GET));
		assertEquals(response.getStatus(), HttpResponseStatus.OK);
		assertEquals(serializer.deserialize(response.getContent(),
				org.iplantc.service.tags.domain.Tag.class)
				.getId(), tag.getId());
	}

	@Test
	public void createTagTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		Response response = call(request("/tags/", HttpMethod.POST,
				Serializer.DEFAULT_JSON_SERIALIZER
						.serialize(tag)));
		assertEquals(response.getStatus(), HttpResponseStatus.CREATED);
	}

	@Test
	public void updateTagTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();
		org.iplantc.service.tags.domain.Tag modifiedtag = createDomain(
				org.iplantc.service.tags.domain.Tag.class, 1);
		Response response = call(request("/tags/" + tag.getId(),
				HttpMethod.PUT,
				Serializer.DEFAULT_JSON_SERIALIZER
						.serialize(modifiedtag)));
		assertEquals(response.getStatus(),
				HttpResponseStatus.NO_CONTENT);
		tag.merge();
		assertTrue(compare(modifiedtag, tag, 1));
	}

	@Test
	public void deleteTagTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();
		Response response = call(request("/tags/" + tag.getId(),
				HttpMethod.DELETE));
		assertEquals(response.getStatus(),
				HttpResponseStatus.NO_CONTENT);
		response = call(request("/tags/" + tag.getId(), HttpMethod.GET,
				Serializer.DEFAULT_JSON_SERIALIZER
						.serialize(tag)));
		assertEquals(response.getStatus(), HttpResponseStatus.NOT_FOUND);
	}

	@Test
	public void listTagResourceTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();

		org.iplantc.service.tags.domain.Resource resource = createDomain(org.iplantc.service.tags.domain.Resource.class);
		tag.collection("resources").add(resource);
		tag.persist();

		Response response = call(request("/tags/" + tag.getId()
				+ "/resources/", HttpMethod.GET));
		assertEquals(response.getStatus(), HttpResponseStatus.OK);
		assertEquals(serializer.deserializeCollection(
				response.getContent(), java.util.List.class,
				org.iplantc.service.tags.domain.Resource.class)
				.size(), tag.getResources().size());
	}

	@Test
	public void readTagResourceTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();
		org.iplantc.service.tags.domain.Resource resource = createDomain(org.iplantc.service.tags.domain.Resource.class);
		tag.collection("resources").add(resource);
		tag.persist();
		Response response = call(request("/tags/" + tag.getId()
				+ "/resources/" + resource.getId(),
				HttpMethod.GET));
		assertEquals(response.getStatus(), HttpResponseStatus.OK);
		assertEquals(serializer.deserialize(response.getContent(),
				org.iplantc.service.tags.domain.Resource.class)
				.getId(), resource.getId());
	}

	@Test
	public void createTagResourceTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();
		org.iplantc.service.tags.domain.Resource resource = createDomain(org.iplantc.service.tags.domain.Resource.class);
		Response response = call(request("/tags/" + tag.getId()
				+ "/resources/", HttpMethod.POST,
				Serializer.DEFAULT_JSON_SERIALIZER
						.serialize(resource)));
		assertEquals(response.getStatus(), HttpResponseStatus.CREATED);
	}

	@Test
	public void updateTagResourceTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();
		org.iplantc.service.tags.domain.Resource resource = createDomain(org.iplantc.service.tags.domain.Resource.class);
		tag.collection("resources").add(resource);
		tag.persist();
		org.iplantc.service.tags.domain.Resource modifiedresource = createDomain(
				org.iplantc.service.tags.domain.Resource.class,
				1);
		Response response = call(request("/tags/" + tag.getId()
				+ "/resources/" + resource.getId(),
				HttpMethod.PUT,
				Serializer.DEFAULT_JSON_SERIALIZER
						.serialize(modifiedresource)));
		assertEquals(response.getStatus(),
				HttpResponseStatus.NO_CONTENT);
		resource.merge();
		assertTrue(compare(modifiedresource, resource, 1));
	}

	@Test
	public void deleteTagResourceTest() {
		org.iplantc.service.tags.domain.Tag tag = createDomain(org.iplantc.service.tags.domain.Tag.class);
		tag.persist();
		org.iplantc.service.tags.domain.Resource resource = createDomain(org.iplantc.service.tags.domain.Resource.class);
		tag.collection("resources").add(resource);
		tag.persist();
		Response response = call(request("/tags/" + tag.getId()
				+ "/resources/" + resource.getId(),
				HttpMethod.DELETE));
		assertEquals(response.getStatus(),
				HttpResponseStatus.NO_CONTENT);
		response = call(request("/tags/" + tag.getId() + "/resources/"
				+ resource.getId(), HttpMethod.GET,
				Serializer.DEFAULT_JSON_SERIALIZER
						.serialize(resource)));
		assertEquals(response.getStatus(), HttpResponseStatus.NOT_FOUND);
	}

}