package javastrava.api.v3.rest;

import javastrava.api.v3.auth.TokenService;
import javastrava.api.v3.auth.model.TokenResponse;
import javastrava.api.v3.rest.async.StravaAPICallback;
import javastrava.api.v3.service.exception.UnauthorizedException;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * <p>
 * API implementation of the Strava REST interface for token management
 * </p>
 *
 * @author Dan Shannon
 *
 */
public interface TokenAPI {
	/**
	 * @see TokenService#deauthorise(javastrava.api.v3.auth.model.Token)
	 *
	 * @param accessToken
	 *            The access token for which the application is revoking its access.
	 * @param callback The callback to execute on completion
	 * @throws UnauthorizedException
	 *             if the token is not allowed to be deauthorised
	 */
	@FormUrlEncoded
	@POST("/oauth/deauthorize")
	public void deauthorise(@Field("access_token") final String accessToken, final StravaAPICallback<TokenResponse> callback) throws UnauthorizedException;

	/**
	 * @see TokenService#deauthorise(javastrava.api.v3.auth.model.Token)
	 *
	 * @param accessToken
	 *            The access token for which the application is revoking its access.
	 * @return Responds with the access token submitted with the request.
	 * @throws UnauthorizedException
	 *             if the token is not allowed to be deauthorised
	 */
	@FormUrlEncoded
	@POST("/oauth/deauthorize")
	public TokenResponse deauthoriseToken(@Field("access_token") final String accessToken) throws UnauthorizedException;

}
