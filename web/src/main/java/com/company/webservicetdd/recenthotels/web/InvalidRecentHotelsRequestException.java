package com.company.webservicetdd.recenthotels.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Marks invalid recent hotels requests.
 *
 * @author Daniel_Imre
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Missing request parameter.")
public class InvalidRecentHotelsRequestException extends RuntimeException {
}
