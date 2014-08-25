package prueba;

import java.io.File;
import org.sigep.core.signs.certificado.util.DataStream;
import org.sigep.core.signs.certificado.x509.cer.P12CertificateSeg;
import org.sigep.core.signs.certificado.x509.cer.X509CertificateSeg;

/**
 * Clase de prueba para firmar documentos y verificar si un archivo
 * realizó modificaciones después de la firma
 * @author rcoarite
 */
public class FirmarDocumetos
{
    public static void main(String cor[]) throws Exception
    {
        String ruta_certificado = "c:\\llaves\\certificado_privado_entidad.p12";
        String ruta_archivo = "c:\\llaves\\texto.txt";
        String ruta_archivo_firmado = "c:\\llaves\\texto.txt.sig";
        String clave_certificado = "clavesecreta";
        
        // Leyendo el archivo generado
        P12CertificateSeg certificateP12 = P12CertificateSeg.load(ruta_certificado,clave_certificado);
        
        // Firmando documento
        certificateP12.sign(DataStream.load(new File(ruta_archivo)),ruta_archivo_firmado);
        
        // Verificamos si el archivo sufrio modificaciones con la firma
        // Se utiliza la llave publica para verificación de la autenticidad
     /*   X509CertificateSeg certificateSeg = certificateP12.getX509CertificateSeg();
        boolean resultado = certificateSeg.verify(DataStream.load(new File(ruta_archivo)),DataStream.load(new File(ruta_archivo_firmado)));
        if(resultado)
            System.out.println("El archivo no sufrio modificacion y es autentico");
        else
            System.out.println("El archivo no es el mismo");*/
    }
}