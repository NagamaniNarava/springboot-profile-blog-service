package com.learninggeeks.profileblog.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomStringDeserializer extends JsonDeserializer<List<ApplicantSkills>> {

	@Override
	public List<ApplicantSkills> deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature. ACCEPT_SINGLE_VALUE_AS_ARRAY);
        LinkedHashMap<String, String> map = mapper.readValue(p, LinkedHashMap.class);
        List<ApplicantSkills> list = new ArrayList<ApplicantSkills>();
        return list;
	}
}
