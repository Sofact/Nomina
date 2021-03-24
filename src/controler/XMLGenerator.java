package controler;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLGenerator {
	
	public void generator() {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			
			//inicia la creacion del XML
			
			Element rootElement = doc.createElement("NominaIndividual");
			doc.appendChild(rootElement);
			
			Attr xmlns = doc.createAttribute("xmlns");
			xmlns.setValue("dian:gov:co:facturaelectronica:NominaIndividual");
			rootElement.setAttributeNode(xmlns);
			
			Attr xmlnsXs = doc.createAttribute("xmlns:xs");
			xmlnsXs.setValue("http://www.w3.org/2001/XMLSchema-instance");
			rootElement.setAttributeNode(xmlnsXs);
			
			Attr xmlnsDs = doc.createAttribute("xmlns:ds");
			xmlnsDs.setValue("http://www.w3.org/2000/09/xmldsig#");
			rootElement.setAttributeNode(xmlnsDs);
			
			Attr xmlnsExt = doc.createAttribute("xmlns:ext");
			xmlnsExt.setValue("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
			rootElement.setAttributeNode(xmlnsExt);
			
			Attr xmlnsXades = doc.createAttribute("xmlns:xades");
			xmlnsXades.setValue("http://uri.etsi.org/01903/v1.3.2#");
			rootElement.setAttributeNode(xmlnsXades);
			
			Attr xmlnsXades141 = doc.createAttribute("xmlns:xades141");
			xmlnsXades141.setValue("http://uri.etsi.org/01903/v1.4.1");
			rootElement.setAttributeNode(xmlnsXades141);
			
			Attr xmlnsXsi = doc.createAttribute("xmlns:xsi");
			xmlnsXsi.setValue("http://www.w3.org/2001/XMLSchema-instance");
			rootElement.setAttributeNode(xmlnsXsi);
			
			Attr SchemaLocation = doc.createAttribute("SchemaLocation");
			SchemaLocation.setValue("");
			rootElement.setAttributeNode(SchemaLocation);
			
			Attr xsiSchemaLocation = doc.createAttribute("xsi:SchemaLocation");
			xsiSchemaLocation.setValue("dian:gov:co:facturaelectronica:NominaIndividual NominaIndividualElectronicaXSD.xsd");
			rootElement.setAttributeNode(xsiSchemaLocation);
			
			Element UBLExtensions = doc.createElement("ext:UBLExtensions");
			rootElement.appendChild(UBLExtensions);
			
			Element novedad = doc.createElement("Novedad");
			rootElement.appendChild(novedad);
			novedad.appendChild( doc.createTextNode( "false"));
			
			Attr cuneNov = doc.createAttribute("CUNENov");
			cuneNov.setValue("modifiCunenovedad"); //aqui debe ir el cune que se modifica por novedad
			novedad.setAttributeNode(cuneNov);
			
			Element periodo = doc.createElement("Periodo");
			rootElement.appendChild(periodo);
			
			Attr fechaIngreso = doc.createAttribute("FechaIngreso");
			fechaIngreso.setValue("9999-12-31"); //aqui debe ir la fecha de ingreso del trabajador
			periodo.setAttributeNode(fechaIngreso);
			
			Attr fechaRetiro = doc.createAttribute("FechaRetiro");
			fechaRetiro.setValue("9999-12-31"); //aqui debe ir la fecha de retiro del trabajador
			periodo.setAttributeNode(fechaRetiro);
			
			Attr fechaLiqIni = doc.createAttribute("FechaLiquidacionInicio");
			fechaLiqIni.setValue("9999-12-31"); //aqui debe ir la fecha de ingreso del trabajador
			periodo.setAttributeNode(fechaLiqIni);
			
			Attr fechaLiqFin = doc.createAttribute("FechaLiquidacionFin");
			fechaLiqFin.setValue("9999-12-31"); //aqui debe ir la fecha de retiro del trabajador
			periodo.setAttributeNode(fechaLiqFin);
			
			
			Attr tiempoLaborado = doc.createAttribute("TiempoLaborado");
			tiempoLaborado.setValue("0"); //aqui debe ir la cantidad de días laborados por el trabajador
			periodo.setAttributeNode(tiempoLaborado);
			
			Attr fechaGen = doc.createAttribute("FechaGen");
			fechaGen.setValue("9999-12-31"); //aqui debe ir la fecha de emisión del documento
			periodo.setAttributeNode(fechaGen);
			
			Element numSecXml = doc.createElement("NumeroSecuenciaXML");
			rootElement.appendChild(numSecXml);
			
			Attr codigoTrabajador = doc.createAttribute("CodigoTrabajador");
			codigoTrabajador.setValue("80797692"); //aqui debe ir la cedula del trabajador
			numSecXml.setAttributeNode(codigoTrabajador);
			
			Attr prefijo = doc.createAttribute("Prefijo");
			prefijo.setValue("NE"); //aqui debe ir el prefijo del documento electronico registrado en al dian
			numSecXml.setAttributeNode(prefijo);
			
			Attr consecutivo = doc.createAttribute("Consecutivo");
			consecutivo.setValue("001"); //aqui debe ir el  consecutivo del documento electronico registrado en al dian
			numSecXml.setAttributeNode(consecutivo);
			
			Attr numero = doc.createAttribute("Numero");
			numero.setValue("NE001"); //aqui debe ir el prefijo concatenado con el  consecutivo del documento electronico registrado en al dian
			numSecXml.setAttributeNode(numero);
			
			Element lugarGenXML = doc.createElement("LugarGeneracionXML");
			rootElement.appendChild(lugarGenXML);
			
			Attr pais = doc.createAttribute("Pais");
			pais.setValue("CO"); //aqui debe ir el codigo alfa 2 del pais segun la tabla 5.4.1 de la dian
			lugarGenXML.setAttributeNode(pais);
			
			Attr deptoEstado = doc.createAttribute("DepartamentoEstado");
			deptoEstado.setValue("11"); //aqui debe ir el codigo del departamento segun la tabla 5.4.2 de la dian
			lugarGenXML.setAttributeNode(deptoEstado);
			
			Attr muniCiudad = doc.createAttribute("MunicipioCiudad");
			muniCiudad.setValue("001"); //aqui debe ir el codigo del departamento segun la tabla 5.4.3 de la dian
			lugarGenXML.setAttributeNode(muniCiudad);
			
			Attr idioma = doc.createAttribute("Idioma");
			idioma.setValue("es"); //aqui debe ir el codigo del idioma que es español
			lugarGenXML.setAttributeNode(idioma);
			
			Element proveedorXML = doc.createElement("ProveedorXML");
			rootElement.appendChild(proveedorXML);
			
			Attr provRazonSocial = doc.createAttribute("RazonSocial");
			provRazonSocial.setValue("SofAct"); //aqui debe ir el nombre del proveedor de software
			proveedorXML.setAttributeNode(provRazonSocial);
			
			Attr provPrimerApellido = doc.createAttribute("PrimerApellido");
			provPrimerApellido.setValue("Jaimes"); //aqui debe ir el nombre del proveedor de software
			proveedorXML.setAttributeNode(provPrimerApellido);
			
			Attr provSegundoApellido = doc.createAttribute("SegundoApellido");
			provSegundoApellido.setValue("Rodriguez"); //aqui debe ir el nombre del proveedor de software
			proveedorXML.setAttributeNode(provSegundoApellido);
			
			Attr provPrimerNombre = doc.createAttribute("PrimerNombre");
			provPrimerNombre.setValue("Hugo"); //aqui debe ir el nombre del proveedor de software
			proveedorXML.setAttributeNode(provPrimerNombre);
			
			Attr provOtrosNombres = doc.createAttribute("OtrosNombres");
			provOtrosNombres.setValue("Julian"); //aqui debe ir el nombre del proveedor de software
			proveedorXML.setAttributeNode(provOtrosNombres);
			
			Attr provNit = doc.createAttribute("NIT");
			provNit.setValue("900001"); //aqui debe ir el nit  del proveedor de software
			proveedorXML.setAttributeNode(provNit);
			
			Attr provDv = doc.createAttribute("DV");
			provDv.setValue("1"); //aqui debe ir el digito de verificacion  del proveedor de software
			proveedorXML.setAttributeNode(provDv);
			
			Attr provSoftwareId = doc.createAttribute("SoftwareID");
			provSoftwareId.setValue("AASDFAASVASD2342SADFAsdfQ34"); //aqui debe ir el software id que entrega la Dian
			proveedorXML.setAttributeNode(provSoftwareId);
			
			Attr provSoftwareSC = doc.createAttribute("SoftwareSC");
			provSoftwareSC.setValue("AASDFAASVASD2342SADFAsdfQ34"); //aqui debe ir el software security code segun el item 8.3
			proveedorXML.setAttributeNode(provSoftwareSC);
			
			Element CodigoQR = doc.createElement("CodigoQR");
			rootElement.appendChild(CodigoQR);
			CodigoQR.appendChild( doc.createTextNode( "QRcode")); //aqui debe ir va el texto de creacion del codigo QR
			
			Element infoGeneral = doc.createElement("InformacionGeneral");
			rootElement.appendChild(infoGeneral);
			
			Attr version = doc.createAttribute("Version");
			version.setValue("V1.0 Documento Soporte de Pago de Nómina Electrónica"); //aqui debe ir el texto literal "V1.0 Documento Soporte de Pago de Nómina Electrónica"
			infoGeneral.setAttributeNode(version);
			
			Attr ambiente = doc.createAttribute("Ambiente");
			ambiente.setValue("1"); //aqui debe ir 1 para produccion 2 para pruebas
			infoGeneral.setAttributeNode(ambiente);
			
			Attr tipoXml = doc.createAttribute("TipoXML");
			tipoXml.setValue("102"); //aqui debe ir 102 para NominaIndividual 103  para NominaIndividual de Ajuste 
			infoGeneral.setAttributeNode(tipoXml);
			
			Attr cune = doc.createAttribute("CUNE");
			cune.setValue("casdcasdcasdf"); //aqui debe ir el CUNE SEGUN 8.1 
			infoGeneral.setAttributeNode(cune);
			
			Attr encripCune = doc.createAttribute("EncripCUNE");
			encripCune.setValue("CUNE-SHA384"); //aqui debe ir LITERAL "CUNE-SHA84"
			infoGeneral.setAttributeNode(encripCune);
			
			Attr igFechaGen = doc.createAttribute("FechaGen");
			igFechaGen.setValue("9999-12-31"); //aqui debe ir fecha de generación del documento formato AAAA-MM-DD
			infoGeneral.setAttributeNode(igFechaGen);
			
			Attr igHoraGen = doc.createAttribute("HoraGen");
			igHoraGen.setValue("9999-12-31"); //aqui debe ir la hora de generación del documento formato HH:MM:SSdhh:mm
			infoGeneral.setAttributeNode(igHoraGen);
			
			Attr igPeriodoNomina = doc.createAttribute("PeriodoNomina");
			igPeriodoNomina.setValue("4"); //aqui debe ir el tipo el periodo de nomina 4 para quincenal segun la tabla 5.5.1
			infoGeneral.setAttributeNode(igPeriodoNomina);
			
			Attr igTipoMoneda = doc.createAttribute("TipoMoneda");
			igTipoMoneda.setValue("COP"); //aqui debe ir LITERAL "COP"
			infoGeneral.setAttributeNode(igTipoMoneda);
			
			Attr igTRM = doc.createAttribute("TRM");
			igTRM.setValue("0"); //aqui debe ir la trm
			infoGeneral.setAttributeNode(igTRM);
			
			Element notas = doc.createElement("Notas");
			rootElement.appendChild(notas); // aqui se pueden agregar notas 
			
			Element empleador = doc.createElement("Empleador");
			rootElement.appendChild(empleador);
			
			Attr emRazonSocial = doc.createAttribute("RazonSocial");
			emRazonSocial.setValue("P RAVELO ALARCON"); //aqui debe la razon social del empleador
			empleador.setAttributeNode(emRazonSocial);
			
			
			Attr emPrimerApellido = doc.createAttribute("PrimerApellido");
			emPrimerApellido.setValue("RAVELO"); //aqui debe IR EL PRIMER APELLIDO DEL EMPLEADOR
			empleador.setAttributeNode(emPrimerApellido);
			
			Attr emSegundoApellido = doc.createAttribute("SegundoApellido");
			emSegundoApellido.setValue("BERMUDEZ"); //aqui debe IR EL SEGUNDO APELLIDO DEL EMPLEADOR
			empleador.setAttributeNode(emSegundoApellido);
			
			Attr emPrimerNombre = doc.createAttribute("PrimerNombre");
			emPrimerNombre.setValue("ADRIANA"); //aqui debe IR EL PRIMER NOMBRE DEL EMPLEADOR
			empleador.setAttributeNode(emPrimerNombre);
			
			Attr emOtrosNombres = doc.createAttribute("OtrosNombres");
			emOtrosNombres.setValue("JAZMIN"); //aqui debe IR EL SEGUNDO NOMBRE DEL EMPLEADOR
			empleador.setAttributeNode(emOtrosNombres);
			
			
			Attr emNIT = doc.createAttribute("NIT");
			emNIT.setValue("53117601"); //aqui debe IR EL NIT DEL EMPLEADOR
			empleador.setAttributeNode(emNIT);
			
			Attr emDV = doc.createAttribute("DV");
			emDV.setValue("3"); //aqui debe IR EL DIGITO DE VERIFICACION DEL EMPLEADOR
			empleador.setAttributeNode(emDV);
			
			Attr emPais = doc.createAttribute("Pais");
			emPais.setValue("CO"); //aqui debe IR EL CODIGO ALFO 2 DEL PAIS TABLA 5.4.1 DEL EMPLEADOR
			empleador.setAttributeNode(emPais);
			
			Attr emDepartamentoEstado = doc.createAttribute("DepartamentoEstado");
			emDepartamentoEstado.setValue("11"); //aqui debe IR EL CODIGODEL DEPARTAMENTO SEGUN TABLA 5.4.2 DEL EMPLEADOR
			empleador.setAttributeNode(emDepartamentoEstado);
			
			Attr emMunicipioCiudad = doc.createAttribute("MunicipioCiudad");
			emMunicipioCiudad.setValue("001"); //aqui debe IR EL CODIGO DEL MUNICIPIO SEGUN TABLA 5.4.3 DEL EMPLEADOR
			empleador.setAttributeNode(emMunicipioCiudad);
			
			Attr emDireccion = doc.createAttribute("Direccion");
			emDireccion.setValue("AV CRA 68 # 28 - 53 SUR"); //aqui debe IR LA DIRECCION DEL EMPLEADOR
			empleador.setAttributeNode(emDireccion);
			
			Element trabajador = doc.createElement("Trabajador");
			rootElement.appendChild(trabajador);
			
			Attr trTipoTrabajador = doc.createAttribute("TipoTrabajador");
			trTipoTrabajador.setValue("01"); //aqui debe tipo de trabajador tabla 5.5.3
			trabajador.setAttributeNode(trTipoTrabajador);
			
			Attr trSubTipoTrabajador = doc.createAttribute("SubTipoTrabajador");
			trSubTipoTrabajador.setValue("01"); //aqui debe tipo de trabajador tabla 5.5.4
			trabajador.setAttributeNode(trSubTipoTrabajador);
			
			Attr trAltoRiesgoPension = doc.createAttribute("AltoRiesgoPension");
			trAltoRiesgoPension.setValue("false"); //aqui debe IR true o false
			trabajador.setAttributeNode(trAltoRiesgoPension);
			
			Attr trTipoDocumento = doc.createAttribute("TipoDocumento");
			trTipoDocumento.setValue("13"); //aqui debe ir codigo segun la tabla 5.2.1
			trabajador.setAttributeNode(trTipoDocumento);
			
			Attr trNumeroDocumento = doc.createAttribute("NumeroDocumento");
			trNumeroDocumento.setValue("80797692"); //aqui debe ir EL NUMERO DE DOCUMENTO DEL TRABAJADOR
			trabajador.setAttributeNode(trNumeroDocumento);
			
			Attr trPrimerApellido = doc.createAttribute("PrimerApellido");
			trPrimerApellido.setValue("JAIMES"); //aqui debe ir EL PRIMER APELLIDO DEL TRABAJADOR
			trabajador.setAttributeNode(trPrimerApellido);
			
			Attr trSegundoApellido = doc.createAttribute("SegundoApellido");
			trSegundoApellido.setValue("RODRIGUEZ"); //aqui debe ir EL SEGUNDP APELLIDO DEL TRABAJADOR
			trabajador.setAttributeNode(trSegundoApellido);
			
			Attr trPrimerNombre = doc.createAttribute("PrimerNombre");
			trPrimerNombre.setValue("HUGO"); //aqui debe ir EL PRIMER NOMBRE DEL TRABAJADOR
			trabajador.setAttributeNode(trPrimerNombre);
			
			Attr trOtrosNombres = doc.createAttribute("OtrosNombres");
			trOtrosNombres.setValue("JULIAN"); //aqui debe ir EL PRIMER NOMBRE DEL TRABAJADOR
			trabajador.setAttributeNode(trOtrosNombres);
			
			Attr trLugarTrabajoPais = doc.createAttribute("LugarTrabajoPais");
			trLugarTrabajoPais.setValue("CO"); //aqui debe ir EL CODIGO ALFA 2 DE LA TABLA 5.4.1 DEL TRABAJADOR
			trabajador.setAttributeNode(trLugarTrabajoPais);
			
			Attr trLugarTrabajoDepartamentoEstado = doc.createAttribute("LugarTrabajoDepartamentoEstado");
			trLugarTrabajoDepartamentoEstado.setValue("11"); //aqui debe ir EL CODIGO DEL DEPARTAMENTOP DE LA TABLA 5.4.2 DEL TRABAJADOR
			trabajador.setAttributeNode(trLugarTrabajoDepartamentoEstado);
			
			Attr trLugarTrabajoMunicipioCiudad = doc.createAttribute("LugarTrabajoMunicipioCiudad");
			trLugarTrabajoMunicipioCiudad.setValue("001"); //aqui debe ir EL CODIGO DEL MUNICIPIO DE LA TABLA 5.4.3 DEL TRABAJADOR
			trabajador.setAttributeNode(trLugarTrabajoMunicipioCiudad);
			
			Attr trLugarTrabajoDireccion = doc.createAttribute("LugarTrabajoDireccion");
			trLugarTrabajoDireccion.setValue("AV CRA 68 # 28 - 53 SUR"); //aqui debe ir LA DIRECCION FISICA DEL TRABAJADOR
			trabajador.setAttributeNode(trLugarTrabajoDireccion);
			
			Attr trSalarioIntegral = doc.createAttribute("SalarioIntegral");
			trSalarioIntegral.setValue("false"); //aqui debe ir "true" o "false"
			trabajador.setAttributeNode(trSalarioIntegral);
			
			Attr trTipoContrato = doc.createAttribute("TipoContrato");
			trTipoContrato.setValue("01"); //aqui debe ir el codigo de la tabla 5.5.2
			trabajador.setAttributeNode(trTipoContrato);
			
			Attr trSueldo = doc.createAttribute("Sueldo");
			trSueldo.setValue("01"); //aqui debe ir el el sueldo base del trabajador en la empresa
			trabajador.setAttributeNode(trSueldo);
			
			Attr trCodigoTrabajador = doc.createAttribute("CodigoTrabajador");
			trCodigoTrabajador.setValue("01"); //aqui debe ir campo discrecional para poner el codigo del trabajador puede ser la cedula
			trabajador.setAttributeNode(trCodigoTrabajador);
			
			Element pago = doc.createElement("Pago");
			rootElement.appendChild(pago);
			
			Attr pagoForma = doc.createAttribute("Forma");
			pagoForma.setValue("01"); //aqui debe ir el codigo de la tabla 5.3.3.1
			pago.setAttributeNode(pagoForma);
			
			Attr pagoMetodo = doc.createAttribute("Metodo");
			pagoMetodo.setValue("01"); //aqui debe ir el codigo de la tabla 5.3.3.2
			pago.setAttributeNode(pagoMetodo);
			
			Attr pagoBanco = doc.createAttribute("Banco");
			pagoBanco.setValue("BANCOLOMBIA"); //aqui debe ir el nombre de la entidad bancaria donde el trabajador tiene la cuenta
			pago.setAttributeNode(pagoBanco);
			
			Attr pagoTipoCuenta = doc.createAttribute("TipoCuenta");
			pagoTipoCuenta.setValue("AHORROS"); //aqui debe ir el tipo de cuenta que el trabajador tiene para pago de nomina
			pago.setAttributeNode(pagoTipoCuenta);
			
			Attr pagoNumeroCuenta = doc.createAttribute("NumeroCuenta");
			pagoNumeroCuenta.setValue("Bancolombia"); //aqui debe ir el NUMERO de cuenta que el trabajador tiene para pago de nomina
			pago.setAttributeNode(pagoNumeroCuenta);
			
			Element FechasPagos = doc.createElement("FechasPagos");
			rootElement.appendChild(FechasPagos);
			
			Element FechaPago = doc.createElement("FechaPago");
			FechasPagos.appendChild(FechaPago);
			FechaPago.appendChild( doc.createTextNode( "9999-12-31")); //aqui debe ir la fecha de pago en formato AAAA-MM-DD
			
			Element Devengados = doc.createElement("Devengados");
			rootElement.appendChild(Devengados);
			
			Element devBasico = doc.createElement("Basico");
			Devengados.appendChild(devBasico);
			
			Attr DiasTrabajados = doc.createAttribute("DiasTrabajados");
			DiasTrabajados.setValue("15"); //aqui debe ir el numero de días trabajados durante el periodo de pago
			devBasico.setAttributeNode(DiasTrabajados);
			
			Attr SueldoTrabajado = doc.createAttribute("SueldoTrabajado");
			SueldoTrabajado.setValue("498000.0"); //aqui debe ir el sueldo del trabajador por los días trabajados
			devBasico.setAttributeNode(SueldoTrabajado);
			
			Element Transporte = doc.createElement("Transporte");
			Devengados.appendChild(Transporte);
			
			Attr AuxilioTransporte = doc.createAttribute("AuxilioTransporte");
			AuxilioTransporte.setValue("498000.0"); //aqui debe ir el valor del subsido de transporte
			Transporte.setAttributeNode(AuxilioTransporte);
			
			Attr ViaticoManutAlojS = doc.createAttribute("ViaticoManutAlojS");
			ViaticoManutAlojS.setValue("498000.0"); //aqui debe ir el valor de los viaticos salariales
			Transporte.setAttributeNode(ViaticoManutAlojS);
			
			Attr ViaticoManutAlojNS = doc.createAttribute("ViaticoManutAlojNS");
			ViaticoManutAlojNS.setValue("498000.0"); //aqui debe ir el valor de los viaticos no salariales
			Transporte.setAttributeNode(ViaticoManutAlojNS);
			
			Element HEDs = doc.createElement("HEDs");
			Devengados.appendChild(HEDs);
			
			Element HED = doc.createElement("HED");
			HEDs.appendChild(HED);
			
			Attr hedHoraInicio = doc.createAttribute("HoraInicio");
			hedHoraInicio.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de inicio de las horas extras formato 9999-12-31T00:00:00
			HED.setAttributeNode(hedHoraInicio);
			
			Attr hedHoraFin = doc.createAttribute("HoraFin");
			hedHoraFin.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de fin de las horas extras formato 9999-12-31T00:00:00
			HED.setAttributeNode(hedHoraFin);
			
			Attr hedCantidad = doc.createAttribute("Cantidad");
			hedCantidad.setValue("0"); //aqui debe ir la cantidad de horas extras
			HED.setAttributeNode(hedCantidad);
			
			Attr hedPorcentaje = doc.createAttribute("Porcentaje");
			hedPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje de la tabla 5.5.5
			HED.setAttributeNode(hedPorcentaje);
			
			Attr hedPago = doc.createAttribute("Pago");
			hedPago.setValue("120000.00"); //aqui debe ir el valor pagado por las horas en formato 0.00
			HED.setAttributeNode(hedPago);
			
			Element HENs = doc.createElement("HENs");
			Devengados.appendChild(HENs);
			
			Element HEN = doc.createElement("HEN");
			HENs.appendChild(HEN);
			
			Attr henHoraInicio = doc.createAttribute("HoraInicio");
			henHoraInicio.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de inicio de las horas extras formato 9999-12-31T00:00:00
			HEN.setAttributeNode(henHoraInicio);
			
			Attr henHoraFin = doc.createAttribute("HoraFin");
			henHoraFin.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de fin de las horas extras formato 9999-12-31T00:00:00
			HEN.setAttributeNode(henHoraFin);
			
			Attr henCantidad = doc.createAttribute("Cantidad");
			henCantidad.setValue("0"); //aqui debe ir la cantidad de horas extras
			HEN.setAttributeNode(henCantidad);
			
			Attr henPorcentaje = doc.createAttribute("Porcentaje");
			henPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje de la tabla 5.5.5
			HEN.setAttributeNode(henPorcentaje);
			
			Attr henPago = doc.createAttribute("Pago");
			henPago.setValue("120000.00"); //aqui debe ir el valor pagado por las horas en formato 0.00
			HEN.setAttributeNode(henPago);
			
			Element HRNs = doc.createElement("HRNs");
			Devengados.appendChild(HRNs);
			
			Element HRN = doc.createElement("HRN");
			HRNs.appendChild(HRN);
			
			Attr herHoraInicio = doc.createAttribute("HoraInicio");
			herHoraInicio.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de inicio de las horas extras formato 9999-12-31T00:00:00
			HRN.setAttributeNode(herHoraInicio);
			
			Attr herHoraFin = doc.createAttribute("HoraFin");
			herHoraFin.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de fin de las horas extras formato 9999-12-31T00:00:00
			HRN.setAttributeNode(herHoraFin);
			
			Attr herCantidad = doc.createAttribute("Cantidad");
			herCantidad.setValue("0"); //aqui debe ir la cantidad de horas extras
			HRN.setAttributeNode(herCantidad);
			
			Attr herPorcentaje = doc.createAttribute("Porcentaje");
			herPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje de la tabla 5.5.5
			HRN.setAttributeNode(herPorcentaje);
			
			Attr herPago = doc.createAttribute("Pago");
			herPago.setValue("120000.00"); //aqui debe ir el valor pagado por las horas en formato 0.00
			HRN.setAttributeNode(herPago);
			
			Element HEDDFs = doc.createElement("HEDDFs");
			Devengados.appendChild(HEDDFs);
			
			Element HEDDF = doc.createElement("HEDDF");
			HEDDFs.appendChild(HEDDF);
			
			Attr heddfHoraInicio = doc.createAttribute("HoraInicio");
			heddfHoraInicio.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de inicio de las horas extras formato 9999-12-31T00:00:00
			HEDDF.setAttributeNode(heddfHoraInicio);
			
			Attr heddfHoraFin = doc.createAttribute("HoraFin");
			heddfHoraFin.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de fin de las horas extras formato 9999-12-31T00:00:00
			HEDDF.setAttributeNode(heddfHoraFin);
			
			Attr heddfCantidad = doc.createAttribute("Cantidad");
			heddfCantidad.setValue("0"); //aqui debe ir la cantidad de horas extras
			HEDDF.setAttributeNode(heddfCantidad);
			
			Attr heddfPorcentaje = doc.createAttribute("Porcentaje");
			heddfPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje de la tabla 5.5.5
			HEDDF.setAttributeNode(heddfPorcentaje);
			
			Attr heddfPago = doc.createAttribute("Pago");
			heddfPago.setValue("120000.00"); //aqui debe ir el valor pagado por las horas en formato 0.00
			HEDDF.setAttributeNode(heddfPago);
			
			Element HRDDFs = doc.createElement("HRDDFs");
			Devengados.appendChild(HRDDFs);
			
			Element HRDDF = doc.createElement("HRDDF");
			HRDDFs.appendChild(HRDDF);
			
			Attr hrddfHoraInicio = doc.createAttribute("HoraInicio");
			hrddfHoraInicio.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de inicio de las horas extras formato 9999-12-31T00:00:00
			HRDDF.setAttributeNode(hrddfHoraInicio);
			
			Attr hrddfHoraFin = doc.createAttribute("HoraFin");
			hrddfHoraFin.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de fin de las horas extras formato 9999-12-31T00:00:00
			HRDDF.setAttributeNode(hrddfHoraFin);
			
			Attr hrddfCantidad = doc.createAttribute("Cantidad");
			hrddfCantidad.setValue("0"); //aqui debe ir la cantidad de horas extras
			HRDDF.setAttributeNode(hrddfCantidad);
			
			Attr hrddfPorcentaje = doc.createAttribute("Porcentaje");
			hrddfPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje de la tabla 5.5.5
			HRDDF.setAttributeNode(hrddfPorcentaje);
			
			Attr hrddfPago = doc.createAttribute("Pago");
			hrddfPago.setValue("120000.00"); //aqui debe ir el valor pagado por las horas en formato 0.00
			HRDDF.setAttributeNode(hrddfPago);
			
			Element HRNDFs = doc.createElement("HRNDFs");
			Devengados.appendChild(HRNDFs);
			
			Element HRNDF = doc.createElement("HRNDF");
			HRNDFs.appendChild(HRNDF);
			
			Attr hrndfHoraInicio = doc.createAttribute("HoraInicio");
			hrndfHoraInicio.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de inicio de las horas extras formato 9999-12-31T00:00:00
			HRNDF.setAttributeNode(hrndfHoraInicio);
			
			Attr hrndfHoraFin = doc.createAttribute("HoraFin");
			hrndfHoraFin.setValue("9999-12-31T00:00:00"); //aqui debe ir Hora de fin de las horas extras formato 9999-12-31T00:00:00
			HRNDF.setAttributeNode(hrndfHoraFin);
			
			Attr hrndfCantidad = doc.createAttribute("Cantidad");
			hrndfCantidad.setValue("0"); //aqui debe ir la cantidad de horas extras
			HRNDF.setAttributeNode(hrndfCantidad);
			
			Attr hrndfPorcentaje = doc.createAttribute("Porcentaje");
			hrndfPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje de la tabla 5.5.5
			HRNDF.setAttributeNode(hrndfPorcentaje);
			
			Attr hrndfPago = doc.createAttribute("Pago");
			hrndfPago.setValue("120000.00"); //aqui debe ir el valor pagado por las horas en formato 0.00
			HRNDF.setAttributeNode(hrndfPago);
			
			Element Vacaciones = doc.createElement("Vacaciones");
			Devengados.appendChild(Vacaciones);
			
			Element VacacionesComunes = doc.createElement("VacacionesComunes");
			Vacaciones.appendChild(VacacionesComunes);
			
			Attr vacComunFechaInicio = doc.createAttribute("FechaInicio");
			vacComunFechaInicio.setValue("9999-12-31"); //aqui debe ir la fecha de inicio DE LAS VACACIONES en formato "AAAA-MM-DD"
			VacacionesComunes.setAttributeNode(vacComunFechaInicio);
			
			Attr vacComunFechaFin = doc.createAttribute("FechaFin");
			vacComunFechaFin.setValue("9999-12-31"); //aqui debe ir la fecha FIN DE LAS VACACIONES en formato "AAAA-MM-DD"
			VacacionesComunes.setAttributeNode(vacComunFechaFin);
			
			Attr vacComunCantidad= doc.createAttribute("Cantidad");
			vacComunCantidad.setValue("15"); //aqui debe ir la cantidad de dias que se van a otorgar de vacaciones
			VacacionesComunes.setAttributeNode(vacComunCantidad);
			
			Attr vacComunPago= doc.createAttribute("Pago");
			vacComunPago.setValue("1500000.00"); //aqui debe ir el valor pagado por als vacaciones
			VacacionesComunes.setAttributeNode(vacComunPago);
			
			Element VacacionesCompensadas = doc.createElement("VacacionesCompensadas");
			Vacaciones.appendChild(VacacionesCompensadas);
			
			Attr vacCompCantidad= doc.createAttribute("Cantidad");
			vacCompCantidad.setValue("15"); //aqui debe ir la cantidad de dias que se van a otorgar de vacaciones compensadas
			VacacionesCompensadas.setAttributeNode(vacCompCantidad);
			
			Attr vacCompPago= doc.createAttribute("Pago");
			vacCompPago.setValue("1500000.00"); //aqui debe ir el valor pagado por als vacaciones compensadas
			VacacionesCompensadas.setAttributeNode(vacCompPago);
			
			Element Primas = doc.createElement("Primas");
			Devengados.appendChild(Primas);
			
			Attr primaCantidad= doc.createAttribute("Cantidad");
			primaCantidad.setValue("15"); //aqui debe ir la cantidad de dias que se van a otorgar de prima
			Primas.setAttributeNode(primaCantidad);
			
			Attr primaPago= doc.createAttribute("Pago");
			primaPago.setValue("1500000.00"); //aqui debe ir el valor pagado por la prima
			Primas.setAttributeNode(primaPago);
			
			Attr primaPagoNS= doc.createAttribute("PagoNS");
			primaPagoNS.setValue("1500000.00"); //aqui debe ir el valor pagado por la prima
			Primas.setAttributeNode(primaPagoNS);
			
			Element Cesantias = doc.createElement("Cesantias");
			Devengados.appendChild(Cesantias);
			
			Attr cesantiasPago= doc.createAttribute("Pago");
			cesantiasPago.setValue("1500000.00"); //aqui debe ir el valor pagado por las cesantias
			Cesantias.setAttributeNode(cesantiasPago);
			
			Attr cesantiasPorcentaje= doc.createAttribute("Porcentaje");
			cesantiasPorcentaje.setValue("0.00"); //aqui debe ir el valor de los intereses de las cesantias
			Cesantias.setAttributeNode(cesantiasPorcentaje);
			
			Attr cesantiasPagoIntereses= doc.createAttribute("PagoIntereses");
			cesantiasPagoIntereses.setValue("1500000.00"); //aqui debe ir el valor pagado por los intereses a las cesantias
			Cesantias.setAttributeNode(cesantiasPagoIntereses);
			
			Element Incapacidades = doc.createElement("Incapacidades");
			Devengados.appendChild(Incapacidades);
			
			Element Incapacidad = doc.createElement("Incapacidad");
			Incapacidades.appendChild(Incapacidad);
			
			Attr incapacidadFechaInicio = doc.createAttribute("FechaInicio");
			incapacidadFechaInicio.setValue("9999-12-31"); //aqui debe ir la fecha de inicio DE LA incapacidad en formato "AAAA-MM-DD"
			Incapacidad.setAttributeNode(incapacidadFechaInicio);
			
			Attr incapacidadFechaFin = doc.createAttribute("FechaFin");
			incapacidadFechaFin.setValue("9999-12-31"); //aqui debe ir la fecha FIN DE LA incapacidad en formato "AAAA-MM-DD"
			Incapacidad.setAttributeNode(incapacidadFechaFin);
			
			Attr incapacidadCantidad= doc.createAttribute("Cantidad");
			incapacidadCantidad.setValue("15"); //aqui debe ir la cantidad de dias de incapacidad
			Incapacidad.setAttributeNode(incapacidadCantidad);
			
			Attr incapacidadPago= doc.createAttribute("Pago");
			incapacidadPago.setValue("1500000.00"); //aqui debe ir el valor pagado por la incapacidad
			Incapacidad.setAttributeNode(incapacidadPago);
			
			Attr incapacidadTipo= doc.createAttribute("Tipo");
			incapacidadTipo.setValue("01"); //aqui debe ir el  codigo del tipo de incapacidad segun la tabla 5.5.6
			Incapacidad.setAttributeNode(incapacidadTipo);
			

			Element Licencias = doc.createElement("Licencias");
			Devengados.appendChild(Licencias);
			
			Element LicenciaMP = doc.createElement("LicenciaMP");
			Licencias.appendChild(LicenciaMP);
			
			Attr licenciaMPFechaInicio = doc.createAttribute("FechaInicio");
			licenciaMPFechaInicio.setValue("9999-12-31"); //aqui debe ir la fecha de inicio DE LA licencia en formato "AAAA-MM-DD"
			LicenciaMP.setAttributeNode(licenciaMPFechaInicio);
			
			Attr licenciaMPFechaFin = doc.createAttribute("FechaFin");
			licenciaMPFechaFin.setValue("9999-12-31"); //aqui debe ir la fecha FIN DE LA licenciaMP en formato "AAAA-MM-DD"
			LicenciaMP.setAttributeNode(licenciaMPFechaFin);
			
			Attr licenciaMPCantidad= doc.createAttribute("Cantidad");
			licenciaMPCantidad.setValue("15"); //aqui debe ir la cantidad de dias de licenciaMP
			LicenciaMP.setAttributeNode(licenciaMPCantidad);
			
			Attr licenciaMPPago= doc.createAttribute("Pago");
			licenciaMPPago.setValue("1500000.00"); //aqui debe ir el valor pagado por la licenciaMP
			LicenciaMP.setAttributeNode(licenciaMPPago);
			
			Element LicenciaR = doc.createElement("LicenciaR");
			Licencias.appendChild(LicenciaR);
			
			Attr licenciaRFechaInicio = doc.createAttribute("FechaInicio");
			licenciaRFechaInicio.setValue("9999-12-31"); //aqui debe ir la fecha de inicio DE LA licencia REM en formato "AAAA-MM-DD"
			LicenciaR.setAttributeNode(licenciaRFechaInicio);
			
			Attr licenciaRFechaFin = doc.createAttribute("FechaFin");
			licenciaRFechaFin.setValue("9999-12-31"); //aqui debe ir la fecha FIN DE LA licencia REM en formato "AAAA-MM-DD"
			LicenciaR.setAttributeNode(licenciaRFechaFin);
			
			Attr licenciaRCantidad= doc.createAttribute("Cantidad");
			licenciaRCantidad.setValue("15"); //aqui debe ir la cantidad de dias de licencia REM
			LicenciaR.setAttributeNode(licenciaRCantidad);
			
			Attr licenciaRPago= doc.createAttribute("Pago");
			licenciaRPago.setValue("1500000.00"); //aqui debe ir el valor pagado por la licenciaREM 
			LicenciaR.setAttributeNode(licenciaRPago);
			
			Element LicenciaNR = doc.createElement("LicenciaNR");
			Licencias.appendChild(LicenciaNR);
			
			Attr licenciaNRFechaInicio = doc.createAttribute("FechaInicio");
			licenciaNRFechaInicio.setValue("9999-12-31"); //aqui debe ir la fecha de inicio DE LA licencia REM en formato "AAAA-MM-DD"
			LicenciaNR.setAttributeNode(licenciaNRFechaInicio);
			
			Attr licenciaNRFechaFin = doc.createAttribute("FechaFin");
			licenciaNRFechaFin.setValue("9999-12-31"); //aqui debe ir la fecha FIN DE LA licencia REM en formato "AAAA-MM-DD"
			LicenciaNR.setAttributeNode(licenciaNRFechaFin);
			
			Attr licenciaNRCantidad= doc.createAttribute("Cantidad");
			licenciaNRCantidad.setValue("15"); //aqui debe ir la cantidad de dias de licencia REM
			LicenciaNR.setAttributeNode(licenciaNRCantidad);
			
			Element Bonificaciones = doc.createElement("Bonificaciones");
			Devengados.appendChild(Bonificaciones);
			
			Element Auxilios = doc.createElement("Auxilios");
			Bonificaciones.appendChild(Auxilios);
			
			Element Auxilio = doc.createElement("Auxilio");
			Auxilios.appendChild(Auxilio);
			
			Attr AuxilioNS= doc.createAttribute("AuxilioNS");
			AuxilioNS.setValue("0.00"); //aqui debe ir EL VALOR DEL AUXILIO NO SALARIAL EN FORMATO 0.00
			Auxilio.setAttributeNode(AuxilioNS);
			
			Attr AuxilioS= doc.createAttribute("AuxilioS");
			AuxilioS.setValue("0.00"); //aqui debe ir EL VALOR DEL AUXILIO SALARIAL EN FORMATO 0.00
			Auxilio.setAttributeNode(AuxilioS);
			
			Element HuelgasLegales = doc.createElement("HuelgasLegales");
			Devengados.appendChild(HuelgasLegales);
			
			Element HuelgaLegal = doc.createElement("HuelgaLegal");
			HuelgasLegales.appendChild(HuelgaLegal);
			
			Attr huelgaLegalFechaInicio = doc.createAttribute("FechaInicio");
			huelgaLegalFechaInicio.setValue("9999-12-31"); //aqui debe ir la fecha de inicio DE LA huelga legal en formato "AAAA-MM-DD"
			HuelgaLegal.setAttributeNode(huelgaLegalFechaInicio);
			
			Attr huelgaLegalFechaFin = doc.createAttribute("FechaFin");
			huelgaLegalFechaFin.setValue("9999-12-31"); //aqui debe ir la fecha FIN DE LA huelga legal en formato "AAAA-MM-DD"
			HuelgaLegal.setAttributeNode(huelgaLegalFechaFin);
			
			Attr huelgaLegalCantidad= doc.createAttribute("Cantidad");
			huelgaLegalCantidad.setValue("15"); //aqui debe ir la cantidad de dias de huelga legal
			HuelgaLegal.setAttributeNode(huelgaLegalCantidad);
			
			Element OtrosConceptos = doc.createElement("OtrosConceptos");
			Devengados.appendChild(OtrosConceptos);
			
			Element Compensaciones = doc.createElement("Compensaciones");
			OtrosConceptos.appendChild(Compensaciones);
			
			Element Compensacion = doc.createElement("Compensacion");
			Compensaciones.appendChild(Compensacion);
			
			Attr CompensacionO = doc.createAttribute("CompensacionO");
			CompensacionO.setValue("0.00"); //aqui debe ir el valor de la compensación o
			Compensacion.setAttributeNode(CompensacionO);
			
			Attr CompensacionE= doc.createAttribute("CompensacionE");
			CompensacionE.setValue("0.00"); //aqui debe ir el valor de la compensación E
			Compensacion.setAttributeNode(CompensacionE);
			
			Element BonoEPCTVs = doc.createElement("BonoEPCTVs");
			Devengados.appendChild(BonoEPCTVs);
			
			Element BonoEPCTV = doc.createElement("BonoEPCTV");
			BonoEPCTVs.appendChild(BonoEPCTV);
			
			Attr BonoEPCTVPagoS= doc.createAttribute("PagoS");
			BonoEPCTVPagoS.setValue("0.00"); //aqui debe ir el valor de la compensación E
			BonoEPCTV.setAttributeNode(BonoEPCTVPagoS);
			
			Attr BonoEPCTVPagoNS= doc.createAttribute("PagoNS");
			BonoEPCTVPagoNS.setValue("0.00"); //aqui debe ir el valor de la compensación E
			BonoEPCTV.setAttributeNode(BonoEPCTVPagoNS);
			
			Attr BonoEPCTVPagoAlimentacionS= doc.createAttribute("PagoAlimentacionS");
			BonoEPCTVPagoAlimentacionS.setValue("0.00"); //aqui debe ir el valor de la compensación E
			BonoEPCTV.setAttributeNode(BonoEPCTVPagoAlimentacionS);
			
			Attr BonoEPCTVPagoAlimentacionNS= doc.createAttribute("PagoAlimentacionNS");
			BonoEPCTVPagoAlimentacionNS.setValue("0.00"); //aqui debe ir el valor de la compensación E
			BonoEPCTV.setAttributeNode(BonoEPCTVPagoAlimentacionNS);
			
			Element Comisiones = doc.createElement("Comisiones");
			Devengados.appendChild(Comisiones);
			
			Element Comision = doc.createElement("Comision");
			Comisiones.appendChild(Comision);
			Comision.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor de la comisión
			
			Element PagosTerceros = doc.createElement("PagosTerceros");
			Devengados.appendChild(PagosTerceros);
			
			Element PagoTercero = doc.createElement("PagoTercero");
			PagosTerceros.appendChild(PagoTercero);
			PagoTercero.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor ddel pago a terceros
			
			Element Anticipos = doc.createElement("Anticipos");
			Devengados.appendChild(Anticipos);
			
			Element Anticipo = doc.createElement("Anticipo");
			Anticipos.appendChild(Anticipo);
			Anticipo.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor de los anticipos realizados
			
			Element Dotacion = doc.createElement("Dotacion");
			Devengados.appendChild(Dotacion);
			Dotacion.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor de la dotacion
			
			Element ApoyoSost = doc.createElement("ApoyoSost");
			Devengados.appendChild(ApoyoSost);
			ApoyoSost.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor del apoyo sostenible
			
			Element Teletrabajo = doc.createElement("Teletrabajo");
			Devengados.appendChild(Teletrabajo);
			Teletrabajo.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por teletrabajo
			
			Element BonifRetiro = doc.createElement("BonifRetiro");
			Devengados.appendChild(BonifRetiro);
			BonifRetiro.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por bonioficacion de retiro
			
			Element Indemnizacion = doc.createElement("Indemnizacion");
			Devengados.appendChild(Indemnizacion);
			Indemnizacion.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por indemnización
			
			Element Reintegro = doc.createElement("Reintegro");
			Devengados.appendChild(Reintegro);
			Reintegro.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por reintegro
			
			Element Deducciones = doc.createElement("Deducciones");
			rootElement.appendChild(Deducciones);
			
			Element Salud = doc.createElement("Salud");
			Deducciones.appendChild(Salud);
			
			Attr saludPorcentaje= doc.createAttribute("Porcentaje");
			saludPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje a deducir por salud
			Salud.setAttributeNode(saludPorcentaje);
			
			Attr saludDeduccion= doc.createAttribute("Deduccion");
			saludDeduccion.setValue("0.00"); //aqui debe ir el valor a deducir por salud
			Salud.setAttributeNode(saludDeduccion);
			
			Element FondoPension = doc.createElement("FondoPension");
			Deducciones.appendChild(FondoPension);
			
			Attr pensionPorcentaje= doc.createAttribute("Porcentaje");
			pensionPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje a deducir por salud
			FondoPension.setAttributeNode(pensionPorcentaje);
			
			Attr pensionDeduccion= doc.createAttribute("Deduccion");
			pensionDeduccion.setValue("0.00"); //aqui debe ir el valor a deducir por salud
			FondoPension.setAttributeNode(pensionDeduccion);
			
			Element FondoSP = doc.createElement("FondoSP");
			Deducciones.appendChild(FondoSP);
			
			Attr FondoSPPorcentaje= doc.createAttribute("Porcentaje");
			FondoSPPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje a deducir por salud
			FondoSP.setAttributeNode(FondoSPPorcentaje);
			
			Attr FondoSPDeduccion= doc.createAttribute("Deduccion");
			FondoSPDeduccion.setValue("0.00"); //aqui debe ir el valor a deducir por salud
			FondoSP.setAttributeNode(FondoSPDeduccion);
			
			Attr FondoSPPorcentajeSub= doc.createAttribute("PorcentajeSub");
			FondoSPPorcentajeSub.setValue("0.00"); //aqui debe ir el porcentaje a deducir por salud
			FondoSP.setAttributeNode(FondoSPPorcentajeSub);
			
			Attr FondoSPDeduccionSub= doc.createAttribute("DeduccionSub");
			FondoSPDeduccionSub.setValue("0.00"); //aqui debe ir el valor a deducir por salud
			FondoSP.setAttributeNode(FondoSPDeduccionSub);
			
			Element Sindicatos = doc.createElement("Sindicatos");
			Deducciones.appendChild(Sindicatos);
			
			Element Sindicato = doc.createElement("Sindicato");
			Sindicatos.appendChild(Sindicato);
			
			Attr sindicatoPorcentaje= doc.createAttribute("Porcentaje");
			sindicatoPorcentaje.setValue("0.00"); //aqui debe ir el porcentaje a deducir por sibndicato
			Sindicato.setAttributeNode(sindicatoPorcentaje);
			
			Attr sindicatoDeduccion= doc.createAttribute("Deduccion");
			sindicatoDeduccion.setValue("0.00"); //aqui debe ir el valor a deducir por sindicato
			Sindicato.setAttributeNode(sindicatoDeduccion);
			
			Element Sanciones = doc.createElement("Sanciones");
			Deducciones.appendChild(Sanciones);
			
			Element Sancion = doc.createElement("Sancion");
			Sanciones.appendChild(Sancion);
			
			Attr SancionPublic= doc.createAttribute("SancionPublic");
			SancionPublic.setValue("0.00"); //aqui debe ir el porcentaje a deducir por Sancion publica
			Sancion.setAttributeNode(SancionPublic);
			
			Attr SancionPriv= doc.createAttribute("SancionPriv");
			SancionPriv.setValue("0.00"); //aqui debe ir el valor a deducir por SancionPriv 
			Sancion.setAttributeNode(SancionPriv);
			
			Element Libranzas = doc.createElement("Libranzas");
			Deducciones.appendChild(Libranzas);
			
			Element Libranza = doc.createElement("Libranza");
			Libranzas.appendChild(Libranza);
			
			Attr libranzaDescripcion= doc.createAttribute("Descripcion");
			libranzaDescripcion.setValue("Motivo del credito"); //aqui debe ir la cantidad de cuotas que el empleado debe pagar a una entidad financiera
			Libranza.setAttributeNode(libranzaDescripcion);
			
			Attr libranzaDeduccion= doc.createAttribute("Deduccion");
			libranzaDeduccion.setValue("0.00"); //aqui debe ir el valor a deducir libranzas
			Libranza.setAttributeNode(libranzaDeduccion);
			
			Element deduccionesPagosTerceros = doc.createElement("PagosTerceros");
			Deducciones.appendChild(deduccionesPagosTerceros);
			
			Element deduccionesPagoTercero = doc.createElement("PagoTercero");
			deduccionesPagosTerceros.appendChild(deduccionesPagoTercero);
			deduccionesPagoTercero.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos a terceros
			
			Element deduccionesAnticipos = doc.createElement("Anticipos");
			Deducciones.appendChild(deduccionesAnticipos);
			
			Element deduccionesAnticipo = doc.createElement("Anticipo");
			deduccionesAnticipos.appendChild(deduccionesAnticipo);
			deduccionesAnticipo.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos DE ANTICIPOS
			
			Element OtrasDeducciones = doc.createElement("OtrasDeducciones");
			Deducciones.appendChild(OtrasDeducciones);
			
			Element OtraDeduccion = doc.createElement("OtraDeduccion");
			OtrasDeducciones.appendChild(OtraDeduccion);
			OtraDeduccion.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos OTRAS DEDUCCIONES
			
			Element PensionVoluntaria = doc.createElement("PensionVoluntaria");
			Deducciones.appendChild(PensionVoluntaria);
			PensionVoluntaria.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos DEPENSION VOLUNTARIA
			
			Element RetencionFuente = doc.createElement("RetencionFuente");
			Deducciones.appendChild(RetencionFuente);
			RetencionFuente.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos RetencionFuente
			
			Element AFC = doc.createElement("AFC");
			Deducciones.appendChild(AFC);
			AFC.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos AFC
			
			Element Cooperativa = doc.createElement("Cooperativa");
			Deducciones.appendChild(Cooperativa);
			Cooperativa.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos COOPERATIVA
			
			Element EmbargoFiscal = doc.createElement("EmbargoFiscal");
			Deducciones.appendChild(EmbargoFiscal);
			EmbargoFiscal.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos EmbargoFiscal
			
			Element PlanComplementarios = doc.createElement("PlanComplementarios");
			Deducciones.appendChild(PlanComplementarios);
			PlanComplementarios.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos EmbargoFiscal
				
			Element Educacion = doc.createElement("Educacion");
			Deducciones.appendChild(Educacion);
			Educacion.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos DE EDUCACION
			
			Element deduccionReintegro = doc.createElement("Reintegro");
			Deducciones.appendChild(deduccionReintegro);
			deduccionReintegro.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos DE reintegro
			
			Element Deuda = doc.createElement("Deuda");
			Deducciones.appendChild(Deuda);
			Deuda.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor por deducciones de pagos DE deudas
			
			Element Redondeo = doc.createElement("Redondeo");
			rootElement.appendChild(Redondeo);
			Redondeo.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor del redondeo
			
			Element DevengadosTotal = doc.createElement("DevengadosTotal");
			rootElement.appendChild(DevengadosTotal);
			DevengadosTotal.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor de la sumatoria de todos los devengados
			
			Element DeduccionesTotal = doc.createElement("DeduccionesTotal");
			rootElement.appendChild(DeduccionesTotal);
			DeduccionesTotal.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor de la sumatoria de todos los deducciones
			
			Element ComprobanteTotal = doc.createElement("ComprobanteTotal");
			rootElement.appendChild(ComprobanteTotal);
			ComprobanteTotal.appendChild( doc.createTextNode( "0.00")); //aqui debe ir el valor de la diferencia entre devengados total y deducciones total
				
			//finaliza la creacion del XML

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			String nombreArchivo = "test";
			String path = "F:";
			new File(path + "" + nombreArchivo).mkdirs();
			System.out.println("El nombre del archivo es:::::" + nombreArchivo + path);
			StreamResult result = new StreamResult(new File(path + nombreArchivo + "\\" + nombreArchivo + "1.xml"));
			transformer.transform(source, result);
			
			//String origenPath = path + gen.generadorNombreArchivo("factura", factura.getFacId())+"\\\\"+ gen.generadorNombreArchivo("factura", factura.getFacId());
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
