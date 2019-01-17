#_pfish module


import os, stat, time
import hashlib, argparse, csv
import logging

log = logging.getLogger('main._pfish')


def ParseCommandLine():
    parser = argparse.ArgumentParser('Python file system hashing .. p-fish')
    parser.add_argument('-v', '--verbose', help='allows progress messages to be displayed', action='store_true')

    group = parser.add_mutually_exclusive_group(required = True)
    group.add_argument('--md5', help = 'specifies MD5 algorithm', action='store_true')
    group.add_argument('--sha256', help = 'specifies SHA256 algorithm', action='store_true')
    group.add_argument('--sha512', help = 'specifies SHA512 algorithm', action='store_true')

    parser.add_argument('-d', '--rootPath', type=ValidateDirectory, required=True, help="specify the root path for hashing")
    parser.add_argument('-r', '--reportPath', type=ValidateDirectoryWritable, required=True, help="specifiy the path for the reports and logs")


    global gl_args
    global gl_hashType
    gl_args = parser.parse_args()

    if gl_args.md5:
        gl_hashType = 'MD5'
    elif gl_args.sha256:
        gl_hashType = 'SHA256'
    elif gl_args.sha512:
        gl_hashType = 'SHA512'
    else:
        gl_hashType = 'Unknown'
        logging.error('Unknown Hash Type Specified')

    DisplayMessage("Command line processed: Successfully")
    return


def WalkPath():
    processCount = 0
    errorCount = 0
    oCVS = _CSVWriter(gl_args.reportPath+'fileSystemReport.csv', gl_hashType)

    log.info('Root Path: ' + gl_args.rootPath)
    for root, dirs, files in os.walk(gl_args.rootPath):
        for file in files:
            fname = os.path.join(root, file)
            result = HashFile(fname, file, oCVS)
            if result is True:
                processCount += 1
            else:
                errorCount += 1
    oCVS.writerClose()
    return(processCount)

def HashFile(theFile, simpleName, o_result):
    if os.path.exists(theFile):
        if not os.path.islink(theFile):
            if os.path.isfile(theFile):
                try:
                    f = open(theFile, 'rb')
                except IOError:
                    log.warning('Open failed: ' + theFile)
                    return
                else:
                    try:
                        rd = f.read()
                    except IOError:
                        f.close()
                        log.warning('Read failed: ' + theFile)
                        return
                    else:
                        theFileStats = os.stat(theFile)
                        (mode, ino, dev, nlink, uid, gid, size, atime, mtime, ctime) = os.stat(theFile)
                        DisplayMessage("Processing File: " + theFile)
                        fileSize = str(size)
                        modifiedTime = time.ctime(mtime)
                        accessTime = time.ctime(atime)
                        createdTime = time.ctime(ctime)
                        ownerID = str(uid)
                        groupID = str(gid)
                        fileMode = bin(mode)
                        if gl_args.md5:
                            hash = hashlib.md5()
                            hash.update(rd)
                            hexMD5 = hash.hexdigest()
                            hashValue = hexMD5.upper()
                        elif gl_args.sha256:
                            hash = hashlib.sha256()
                            hash.update(rd)
                            hexSHA256 = hash.hexdigest()
                            hashValue = hexSHA256.upper()
                        elif gl_args.sha512:
                            hash = hashlib.sha512()
                            hash.update(rd)
                            hexSHA512 = hash.hexdigest()
                            hashValue = hexSHA512.upper()
                        else:
                            log.error('Hash Not Selected')
                        print "******************************"
                        f.close()
                        o_result.writeCSVRow(simpleName, theFile, fileSize, modifiedTime, accessTime, createdTime, hashValue, ownerID, groupID, mode)
                        return True
            else:
                log.warning(theFile + ' , Skipped NOT a File')
                return False
        else:
            log.warning(theFile + ' , Skipped Link NOT a File')
            return False
    else:
        log.warning(theFile + ' , Path does not exist')
        return False

def ValidateDirectory(theDir):
    if not os.path.isdir(theDir):
        raise argparse.ArgumentTypeError('Directory does not exist')

    if os.access(theDir, os.R_OK):
        return theDir
    else:
        raise argparse.ArgumentTypeError('Directory is not readable')

def ValidateDirectoryWritable(theDir):
    if not os.path.isdir(theDir):
        raise argparse.ArgumentTypeError('Directory does not exist')

    if os.access(theDir, os.W_OK):
        return theDir
    else:
        raise argparse.ArgumentTypeError('Directory is not writable')

def DisplayMessage(msg):
    if gl_args.verbose:
        print(msg)
    return

class _CSVWriter:

    def __init__(self, fileName, hashType):
        try:
            self.csvFile = open(fileName, 'wb')
            self.writer = csv.writer(self.csvFile, delimiter=',',quoting=csv.QUOTE_ALL)
            self.writer.writerow( ('File', 'Path', 'Size', 'Modified Time', 'Access Time', 'Created Time', hashType, 'Owner', 'Group', 'Mode') )
        except:
            log.error('CSV File Failure')

    def writeCSVRow(self, fileName, filePath, fileSize, mTime, aTime, cTime, hashVal, own, grp, mod):
        self.writer.writerow( (fileName, filePath, fileSize, mTime, aTime, cTime, hashVal, own, grp, mod))

    def writerClose(self):
        self.csvFile.close()

            
        
    
                            
                    
            
