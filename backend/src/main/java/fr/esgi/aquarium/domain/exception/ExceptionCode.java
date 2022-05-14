package fr.esgi.aquarium.domain.exception;

public class ExceptionCode {
	private ExceptionCode(){}
	public static final String ENTITY_CREATION_ERROR = "TECH_ENTITY_CREATION_ERROR";
	public static final String ENTITY_NOT_FOUND = "FUNC_ENTITY_NOT_FOUND";
	public static final String UPDATE_ENTITY_IMPOSSIBLE_NOT_ALREADY_PERSISTED = "FUNC_UPDATE_ENTITY_IMPOSSIBLE_NOT_ALREADY_PERSISTED";
	public static final String BAD_ID = "FUNC_BAD_ID";
	public static final String ENTITY_ALREADY_EXISTING = "FUNC_ENTITY_ALREADY_EXISTING";
	public static final String TOKEN_NON_VALIDE = "FUNC_TOKEN_NON_VALIDE";
	public static final String UNSUCCESSFUL_LOGIN = "FUNC_UNSUCCESSFUL_LOGIN";
	public static final String ACCESS_DENIED = "FUNC_ACCESS_DENIED";
	public static final String WRONG_DATE_LOGIC = "FUNC_WRONG_DATE_LOGIC";
	public static final String MODIFICATION_IMPOSSIBLE = "FUNC_MODIFICATION_IMPOSSIBLE";
	public static final String WRONG_FORM_DATA = "FUNC_WRONG_FORM_DATA";
	public static final String GENERAL_ERROR = "FUNC_GENERAL_ERROR";
	public static final String ACTIVATION_CODE_ERROR = "FUNC_ACTIVATION_CODE_ERROR";
}
