package com.cognizant.devops.platformservice.test.bulkUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.multipart.MultipartFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cognizant.devops.platformcommons.exception.InsightsCustomException;
import com.cognizant.devops.platformservice.bulkupload.service.BulkUploadService;

@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class BulkUploadTest extends BulkUploadTestData {

	public static final BulkUploadService bulkUploadService = new BulkUploadService();
	public static final BulkUploadTestData bulkUploadTestData = new BulkUploadTestData();

	@Test(priority = 2)
	public void testUploadDataInDatabase() throws InsightsCustomException, IOException {

		FileInputStream input = new FileInputStream(file);
		MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
				IOUtils.toByteArray(input));

		boolean response = bulkUploadService.uploadDataInDatabase(multipartFile, bulkUploadTestData.toolName,
				bulkUploadTestData.label);

		Assert.assertEquals(response, true);
		Assert.assertFalse(multipartFile.isEmpty());
		Assert.assertTrue(multipartFile.getSize() < 2097152);

	}

	@Test(priority = 3, expectedExceptions = InsightsCustomException.class)
	public void testUploadDataInDatabaseException() throws InsightsCustomException, IOException {

		FileInputStream input = new FileInputStream(fileNull);
		MultipartFile multipartFile = new MockMultipartFile("file", fileNull.getName(), "text/plain",
				IOUtils.toByteArray(input));

		boolean response = bulkUploadService.uploadDataInDatabase(multipartFile, bulkUploadTestData.toolNameNull,
				bulkUploadTestData.labelNull);

		Assert.assertEquals(response, false);

	}

	@Test(priority = 1)
	public void testGetToolDetailJson() throws InsightsCustomException {

		String response = bulkUploadService.getToolDetailJson().toString();

		Assert.assertNotNull(response);
		Assert.assertTrue(response.length() > 0);
		Assert.assertNotNull(bulkUploadTestData.toolJson);
		Assert.assertNotNull(bulkUploadTestData.toolName, "GIT");
		Assert.assertNotNull(bulkUploadTestData.label, "SCM:GIT:DATA");

	}

}
