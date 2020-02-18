package com.dsunsoft.common.util;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * HttpClient 工具类
 */
public class HttpClientUtils {
	private static final String HTTP = "http";
	private static final String HTTPS = "https";
	private static SSLConnectionSocketFactory sslsf = null;
	private static PoolingHttpClientConnectionManager cm = null;
	private static SSLContextBuilder builder = null;
	public static final String CONTENT_TYPE = "Content-Type";
	/** form 表单请求 */
	public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded;charset=utf-8";
	/** json 请求 */
	public static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";

	static {
		try {
			builder = new SSLContextBuilder();
			// 全部信任 不做身份鉴定
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					return true;
				}
			});
			sslsf = new SSLConnectionSocketFactory(builder.build(),
					new String[] { "SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2" }, null, NoopHostnameVerifier.INSTANCE);
			Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register(HTTP, new PlainConnectionSocketFactory()).register(HTTPS, sslsf).build();
			cm = new PoolingHttpClientConnectionManager(registry);
			cm.setMaxTotal(200);// max connection
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static CloseableHttpClient getHttpClient() throws Exception {
		//超时时间30秒,单位是毫秒
		RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000)
				.setConnectionRequestTimeout(30000).build();
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm)
				.setConnectionManagerShared(true).setDefaultRequestConfig(defaultRequestConfig).build();
		return httpClient;
	}

	/**
	 * httpClient post请求
	 *
	 * @param url
	 *            请求url
	 * @param header
	 *            头部信息
	 * @param param
	 *            请求参数 form提交适用
	 * @param entity
	 *            请求实体 json/xml提交适用
	 * @return 可能为空 需要处理
	 * @throws Exception
	 */
	public static String doGet(String url, Map<String, String> header, Map<String, String> params) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = null;
		try {
			httpClient = getHttpClient();
			// 设置请求参数
			if (null != params) {
				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					// 给参数赋值
					formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
				String str = EntityUtils.toString(urlEncodedFormEntity);
				url = url + "?" + str;
			}
			HttpGet httpGet = new HttpGet(url);
			// 设置头信息
			if (null != header) {
				for (Map.Entry<String, String> entry : header.entrySet()) {
					httpGet.addHeader(entry.getKey(), entry.getValue());
				}
			}
			HttpResponse httpResponse = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity resEntity = httpResponse.getEntity();
				result = EntityUtils.toString(resEntity);
			} else {
				result = readHttpResponse(httpResponse);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (httpClient != null) {
				httpClient.close();
			}
		}
		return result;
	}

	/**
	 * httpClient post json 参数请求
	 *
	 * @param url
	 *            请求url
	 * @return 可能为空 需要处理
	 * @throws Exception
	 */
	public static String doPost(String url, Map<String, String> params) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = null;
		try {
			httpClient = getHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader(CONTENT_TYPE, CONTENT_TYPE_JSON);
			// 设置请求参数
			if (null != params) {
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(params);
				StringEntity se = new StringEntity(json);
				httpPost.setEntity(se);
			}
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity resEntity = httpResponse.getEntity();
				result = EntityUtils.toString(resEntity);
			} else {
				result = readHttpResponse(httpResponse);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (httpClient != null) {
				httpClient.close();
			}
		}
		return result;
	}

	/**
	 * httpClient post json 参数请求
	 *
	 * @param url
	 *            请求url
	 * @return 可能为空 需要处理
	 * @throws Exception
	 */
	public static String doPost(String url, Map<String, String> header, Map<String, String> params) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = null;
		try {
			httpClient = getHttpClient();
			HttpPost httpPost = new HttpPost(url);
			// 设置请求参数
			if (null != params) {
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(params);
				StringEntity se = new StringEntity(json);
				httpPost.setEntity(se);
			}
			// 设置头信息
			if (null != header) {
				for (Map.Entry<String, String> entry : header.entrySet()) {
					httpPost.addHeader(entry.getKey(), entry.getValue());
				}
			}
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity resEntity = httpResponse.getEntity();
				result = EntityUtils.toString(resEntity);
			} else {
				result = readHttpResponse(httpResponse);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (httpClient != null) {
				httpClient.close();
			}
		}
		return result;
	}

	/**
	 * httpClient post json 参数请求
	 *
	 * @param url
	 *            请求url
	 * @return 可能为空 需要处理
	 * @throws Exception
	 */
	public static String doPost(String url, String json) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = null;
		try {
			httpClient = getHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader(CONTENT_TYPE, CONTENT_TYPE_JSON);
			// 设置请求参数
			if (null != json && !"".equals(json)) {
				StringEntity se = new StringEntity(json);
				httpPost.setEntity(se);
			}
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity resEntity = httpResponse.getEntity();
				result = EntityUtils.toString(resEntity);
			} else {
				result = readHttpResponse(httpResponse);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (httpClient != null) {
				httpClient.close();
			}
		}
		return result;
	}

	/**
	 * httpClient post请求,参数以键值对形式拼接到url
	 *
	 * @param url
	 *            请求url
	 * @param header
	 *            头部信息
	 * @param params
	 *            请求参数 form提交适用
	 * @return 可能为空 需要处理
	 * @throws Exception
	 */
	public static String doPostForUrl(String url, Map<String, String> params) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = null;
		try {
			httpClient = getHttpClient();
			HttpPost httpPost = new HttpPost(url);
			// Fiddler 抓包设置
			// HttpHost proxy = new HttpHost("localhost", 8888, "http");
			// RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			// httpPost.setConfig(config);
			// 设置头信息
			httpPost.addHeader(CONTENT_TYPE, CONTENT_TYPE_FORM);
			// 设置请求参数
			if (null != params) {
				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					// 给参数赋值
					formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
				httpPost.setEntity(urlEncodedFormEntity);
			}
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity resEntity = httpResponse.getEntity();
				result = EntityUtils.toString(resEntity);
			} else {
				result = readHttpResponse(httpResponse);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (httpClient != null) {
				httpClient.close();
			}
		}
		return result;
	}

	/**
	 * httpClient post请求,参数以键值对形式拼接到url
	 *
	 * @param url
	 *            请求url
	 * @param header
	 *            头部信息
	 * @param params
	 *            请求参数 form提交适用
	 * @return 可能为空 需要处理
	 * @throws Exception
	 */
	public static String doPostForUrl(String url, Map<String, String> header, Map<String, String> params)
			throws Exception {
		String result = "";
		CloseableHttpClient httpClient = null;
		try {
			httpClient = getHttpClient();
			HttpPost httpPost = new HttpPost(url);
			// Fiddler 抓包设置
			// HttpHost proxy = new HttpHost("localhost", 8888, "http");
			// RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			// httpPost.setConfig(config);
			// 设置头信息
			if (null != header) {
				for (Map.Entry<String, String> entry : header.entrySet()) {
					httpPost.addHeader(entry.getKey(), entry.getValue());
				}
			}
			// 设置请求参数
			if (null != params) {
				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					// 给参数赋值
					formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
				httpPost.setEntity(urlEncodedFormEntity);
			}
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity resEntity = httpResponse.getEntity();
				result = EntityUtils.toString(resEntity);
			} else {
				result = readHttpResponse(httpResponse);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (httpClient != null) {
				httpClient.close();
			}
		}
		return result;
	}

	/**
	 * 解析返回结果
	 *
	 * @param httpResponse
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String readHttpResponse(HttpResponse httpResponse) throws ParseException, IOException {
		StringBuilder builder = new StringBuilder();
		// 获取响应消息实体
		HttpEntity entity = httpResponse.getEntity();
		// 响应状态
		builder.append("status:" + httpResponse.getStatusLine());
		builder.append("headers:");
		HeaderIterator iterator = httpResponse.headerIterator();
		while (iterator.hasNext()) {
			builder.append("\t" + iterator.next());
		}
		// 判断响应实体是否为空
		if (entity != null) {
			String responseString = EntityUtils.toString(entity);
			builder.append("response length:" + responseString.length());
			builder.append("response content:" + responseString.replace("\r\n", ""));
		}
		return builder.toString();
	}
}