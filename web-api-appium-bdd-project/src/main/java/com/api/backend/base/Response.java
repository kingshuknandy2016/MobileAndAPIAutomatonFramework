package com.api.backend.base;

public class Response {
private transient String messageBody;
	private ClientResponse clientResponse;
	private MultivaluedMap<String, String> headers;
	private Status status;
	private MediaType mediaType;
	private List<NewCookie> cookies;

	private Date lastModified;
  private String language;

	private Date responseDate;

	protected Response() {

	}

	public Response(ClientResponse clientResponse) {
		init(clientResponse);
	}
protected void init(ClientResponse clientResponse) {

		this.clientResponse = clientResponse;
		// messageBody = clientResponse.getEntity(type);
		setRawMessageBody();
		headers = clientResponse.getHeaders();
		status = clientResponse.getClientResponseStatus();
		cookies = clientResponse.getCookies();
		lastModified = clientResponse.getLastModified();
		responseDate = clientResponse.getResponseDate();
		language = clientResponse.getLanguage();

		try {
			mediaType = clientResponse.getType();
		} catch (Exception e) {
			System.err.println("Unable to parse media type. If want to access media type, you may try using 'Content-Type' from header.");
			e.printStackTrace();
		}

	}

	private void setRawMessageBody() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = clientResponse.getEntityInputStream();
		try {
			ReaderWriter.writeTo(in, out);

			byte[] requestEntity = out.toByteArray();
			if (requestEntity.length == 0) {
				return;
			}
			messageBody = new String(requestEntity);

			clientResponse.setEntityInputStream(new ByteArrayInputStream(requestEntity));
		} catch (IOException ex) {
		}

	}
  public String getMessageBody() {
		return messageBody;
	}

	public MultivaluedMap<String, String> getHeaders() {
		return headers;
	}

	public <T> T getEntity(Class<T> t) {
		return clientResponse.getEntity(t);
	}

	public Status getStatus() {
		return status;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public List<NewCookie> getCookies() {
		return cookies;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public String getLanguage() {
		return language;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		try {
			clientResponse.getEntityInputStream().close();
		} catch (IOException e) {

		}
	}

}
